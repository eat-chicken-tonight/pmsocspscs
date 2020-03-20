package pmsocspsc.modules.pms.service.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.Query;

import pmsocspsc.common.utils.RedisUtils;
import pmsocspsc.modules.pms.dao.PmFinishInfoDao;
import pmsocspsc.modules.pms.entity.PmFinishAttachEntity;
import pmsocspsc.modules.pms.entity.PmFinishInfoEntity;
import pmsocspsc.modules.pms.entity.PmFundInfoEntity;
import pmsocspsc.modules.pms.entity.PmItemInfoEntity;
import pmsocspsc.modules.pms.service.*;


@Service("pmFinishInfoService")
public class PmFinishInfoServiceImpl extends ServiceImpl<PmFinishInfoDao, PmFinishInfoEntity> implements PmFinishInfoService {

    @Autowired
    private PmFundInfoService pmFundInfoService;
    @Autowired
    private PmItemInfoService pmItemInfoService;
    @Autowired
    private PmTeamInfoService pmTeamInfoService;
    @Autowired
    private PmFinishAttachService pmFinishAttachService;
    @Autowired
    private RedisUtils redisUtils;
    /**
     * 分页查询
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        ArrayList<PmFinishInfoEntity> entities = new ArrayList<>();

        QueryWrapper ew = new QueryWrapper<PmFinishInfoEntity>().setEntity(new PmFinishInfoEntity());

        Object status = params.get("finishInfoStatus");
        Object userId = params.get("userId");
        if (status!=null&&status!="")ew.eq("finish_info_status",status);
        if (userId!=null&&userId!="")ew.eq("user_id",userId);

        IPage<PmFinishInfoEntity> page = this.page(
                new Query<PmFinishInfoEntity>().getPage(params),ew
        );

        page.getRecords().forEach(v->{
            v.setPmItemInfoEntity(pmItemInfoService.getById(v.getItemInfoId()));
            entities.add(v);
        });

        page.setRecords(entities);

        return new PageUtils(page);
    }

    /**
     * 审批
     * @param params
     */
    @Override
    public void apply(Map<String, Object> params) {

        Object finishInfoId = params.get("finishInfoId");

        String status = params.get("status").toString();

        PmFinishInfoEntity entity = getById((Serializable) finishInfoId);

        entity.setFinishInfoStatus(Integer.parseInt(status));
        //更新
        super.saveOrUpdate(entity);

    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Override
    public PmFinishInfoEntity getById(Serializable id) {

        PmFinishInfoEntity entity = super.getById(id);
        //立项
        entity.setPmItemInfoEntity(pmItemInfoService.getById(entity.getItemInfoId()));
        //预算
        entity.setPmFundInfoEntity(pmFundInfoService.getById(entity.getItemInfoId()));
        //队伍
        entity.setPmTeamInfoEntities(pmTeamInfoService.findByItemId(entity.getItemInfoId()));
        //附件
        //优先查找redis数据库
        PmFinishAttachEntity redisAtta = redisUtils.get(entity.getFinishInfoId().toString(), PmFinishAttachEntity.class);
        //
        if (redisAtta == null) {
            redisAtta = (pmFinishAttachService.findByFinishId(entity.getFinishInfoId()));
            redisUtils.set(redisAtta.getFinishInfoId().toString(),redisAtta);
        }
        entity.setPmFinishAttachEntity(redisAtta);

        return entity;
    }

    /**
     * 保存
     * @param entity
     * @return
     */
    @Override
    public boolean save(PmFinishInfoEntity entity) {

        boolean res = super.save(entity);
        //附件
        PmFinishAttachEntity attachEntity = entity.getPmFinishAttachEntity();
        attachEntity.setFinishInfoId(entity.getFinishInfoId());
        pmFinishAttachService.save(attachEntity);
        //保存到redis
        redisUtils.set(attachEntity.getFinishInfoId().toString(),attachEntity);
        //获奖
        entity.getPmTeamInfoEntities().forEach(v->{pmTeamInfoService.updateBySimple(v);});
        //支出
        PmFundInfoEntity pfie = entity.getPmFundInfoEntity();
        pfie.setTotalCost(pfie.getRegisterCost()+pfie.getTravelCost()+pfie.getTrainCost()+pfie.getReviewCost()+pfie.getGuideCost()+pfie.getLeaderCost()+pfie.getOrganizeCost()+pfie.getConsumablesCost()+pfie.getAwardCost()+pfie.getAnotherCost());
        pfie.setFinishInfoId(entity.getFinishInfoId());
        pmFundInfoService.save(pfie);
        //更新立项项目状态
        PmItemInfoEntity pmItemInfoEntity = pmItemInfoService.getById(entity.getItemInfoId());
        pmItemInfoEntity.setItemInfoFinish(1);
        pmItemInfoService.updateBySimle(pmItemInfoEntity);

        return res;

    }

    /**
     * 更新
     * @param entity
     * @return
     */
    @Override
    public boolean updateById(PmFinishInfoEntity entity) {
        boolean res = super.updateById(entity);
        //参赛队伍奖项
        entity.getPmTeamInfoEntities().forEach(v->{
            pmTeamInfoService.updateBySimple(v);
        });
        //支出
        PmFundInfoEntity pfie = entity.getPmFundInfoEntity();
        pfie.setTotalCost(pfie.getRegisterCost()+pfie.getTravelCost()+pfie.getTrainCost()+pfie.getReviewCost()+pfie.getGuideCost()+pfie.getLeaderCost()+pfie.getOrganizeCost()+pfie.getConsumablesCost()+pfie.getAwardCost()+pfie.getAnotherCost());
        pmFundInfoService.updateById(pfie);
        //附件
        PmFinishInfoEntity infoEntity = getById(entity.getFinishInfoId());
        PmFinishAttachEntity attachEntity = infoEntity.getPmFinishAttachEntity();
        pmFinishAttachService.removeById(attachEntity);
        PmFinishAttachEntity newAttachEntity = entity.getPmFinishAttachEntity();
        newAttachEntity.setFinishInfoId(entity.getFinishInfoId());
        pmFinishAttachService.save(newAttachEntity);
        //清除缓存
        redisUtils.delete(entity.getFinishInfoId().toString());
        //更新缓存
        redisUtils.set(newAttachEntity.getFinishInfoId().toString(),newAttachEntity);
        return res;
    }

    /**
     * 批量删除
     * @param idList
     * @return
     */
    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        idList.forEach(v->{
            PmFinishInfoEntity entity = getById(v);
            //移除支出
            pmFundInfoService.removeById(entity.getPmFundInfoEntity().getBudgetId());
            //移除奖项
            entity.getPmTeamInfoEntities().forEach(value->{
                value.setAwardGrade("");
                value.setAwardInfo("");
                pmTeamInfoService.saveOrUpdate(value);
            });
            //移除附件
            pmFinishAttachService.removeById(entity.getPmFinishAttachEntity().getAttachId());
            //清除缓存
            redisUtils.delete(entity.getFinishInfoId().toString());
            //解除结题状态：
            PmItemInfoEntity itemInfoEntity = pmItemInfoService.getById(getById(v).getItemInfoId());
            itemInfoEntity.setItemInfoFinish(0);
            pmItemInfoService.updateBySimle(itemInfoEntity);
        });

        return super.removeByIds(idList);
    }
}