package pmsocspsc.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.Query;

import pmsocspsc.modules.pms.dao.PmItemInfoDao;
import pmsocspsc.modules.pms.entity.PmFundInfoEntity;
import pmsocspsc.modules.pms.entity.PmItemAttachEntity;
import pmsocspsc.modules.pms.entity.PmItemInfoEntity;
import pmsocspsc.modules.pms.service.PmFinishAttachService;
import pmsocspsc.modules.pms.service.PmFundInfoService;
import pmsocspsc.modules.pms.service.PmItemAttachService;
import pmsocspsc.modules.pms.service.PmItemInfoService;


@Service("pmItemInfoService")
public class PmItemInfoServiceImpl extends ServiceImpl<PmItemInfoDao, PmItemInfoEntity> implements PmItemInfoService {


    @Autowired
    private PmItemAttachService pmItemAttachService;

    @Autowired
    private PmFundInfoService pmFundInfoService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        QueryWrapper ew = new QueryWrapper<PmItemInfoEntity>().setEntity(new PmItemInfoEntity());

        Object key = params.get("key");
        Object status = params.get("itemInfoStatus");
        Object userId = params.get("userId");
        if (key != null && key != "") ew.like("match_name", key);
        if (status != null && status != "") ew.eq("item_info_status", status);
        if (userId != null && userId != "") ew.eq("user_id", userId);

        IPage<PmItemInfoEntity> page = this.page(
                new Query<PmItemInfoEntity>().getPage(params),
                ew
        );
        return new PageUtils(page);
    }


    /**
     * 审批
     *
     * @param params
     */
    @Override
    public void apply(Map<String, Object> params) {

        Integer itemId = Integer.parseInt(params.get("id").toString());

        PmItemInfoEntity entity = getById(itemId);

        entity.setItemInfoStatus(Integer.parseInt(params.get("status").toString()));

        this.updateById(entity);

    }

    /**
     *查询教师的所有立项项目
     * @param userId
     * @return
     */
    @Override
    public List<PmItemInfoEntity> findItemByUserId(Integer userId) {

        QueryWrapper ew = new QueryWrapper<PmItemInfoEntity>().setEntity(new PmItemInfoEntity());

        ew.eq("user_id", userId);

        return super.list(ew);
    }

    /**
     * 简单更新
     * @param itemInfoEntity
     */
    @Override
    public void updateBySimle(PmItemInfoEntity itemInfoEntity) {
        super.updateById(itemInfoEntity);
    }

    /**
     * 保存
     *
     * @param entity
     * @return
     */
    @Override
    public boolean save(PmItemInfoEntity entity) {

        boolean res = super.save(entity);


        PmFundInfoEntity pfie = entity.getPmFundInfoEntity();

        pfie.setItemInfoId(entity.getItemInfoId());

        //合计预算
        pfie.setTotalCost(pfie.getRegisterCost() + pfie.getTravelCost() + pfie.getTrainCost() + pfie.getReviewCost() + pfie.getGuideCost() + pfie.getLeaderCost() + pfie.getOrganizeCost() + pfie.getConsumablesCost() + pfie.getAwardCost() + pfie.getAnotherCost());

        pmFundInfoService.save(entity.getPmFundInfoEntity());

        //保存附件
        if (entity.getPmItemAttachEntity()!=null&&entity.getPmItemAttachEntity().getAttachPath()!=null) {
            PmItemAttachEntity pia = entity.getPmItemAttachEntity();
            pia.setItemInfoId(entity.getItemInfoId());
            pmItemAttachService.save(pia);
        }

        return res;
    }

    /**
     * 查询详情
     *
     * @param id
     * @return
     */
    @Override
    public PmItemInfoEntity getById(Serializable id) {

        PmItemInfoEntity entity = super.getById(id);
        //预算
        entity.setPmFundInfoEntity(pmFundInfoService.findByItemInfoId(entity.getItemInfoId()));
        //附件
        entity.setPmItemAttachEntity(pmItemAttachService.findByItemInfoId(entity.getItemInfoId()));

        return entity;
    }

    /**
     * 删除
     *
     * @param idList
     * @return
     */
    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        idList.forEach(v -> {
            PmItemInfoEntity byId = getById(v);
            pmItemAttachService.removeById(byId.getPmItemAttachEntity().getAttachId());
            pmFundInfoService.removeById(byId.getPmFundInfoEntity().getBudgetId());
            removeById(v);
        });
        return true;
    }

    /**
     * 更新
     *
     * @param entity
     * @return
     */
    @Override
    public boolean updateById(PmItemInfoEntity entity) {

        pmFundInfoService.updateById(entity.getPmFundInfoEntity());

        //预算
        PmFundInfoEntity pfie = entity.getPmFundInfoEntity();
        pfie.setTotalCost(pfie.getRegisterCost() + pfie.getTravelCost() + pfie.getTrainCost() + pfie.getReviewCost() + pfie.getGuideCost() + pfie.getLeaderCost() + pfie.getOrganizeCost() + pfie.getConsumablesCost() + pfie.getAwardCost() + pfie.getAnotherCost());
        pmFundInfoService.updateById(pfie);

        //附件
        PmItemAttachEntity attachEntity = entity.getPmItemAttachEntity();

        //添加
        if (attachEntity.getItemInfoId() == null) {
            //修改
            PmItemInfoEntity temp = getById(entity.getItemInfoId());
            //移除旧的附件
            if (temp.getPmItemAttachEntity()!=null)pmItemAttachService.removeById(temp.getPmItemAttachEntity().getAttachId());
            attachEntity.setItemInfoId(entity.getItemInfoId());
            pmItemAttachService.save(attachEntity);
        } else if (entity.getPmItemAttachEntity().getAttachIsDel() == 1) {
            //删除
            pmItemAttachService.removeById(entity.getPmItemAttachEntity().getAttachId());
        }
        return super.updateById(entity);
    }
}