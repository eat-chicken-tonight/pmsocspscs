package pmsocspsc.modules.pms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.Query;

import pmsocspsc.modules.pms.dao.PmTeamInfoDao;
import pmsocspsc.modules.pms.dao.PmTeamPersonInfoDao;
import pmsocspsc.modules.pms.entity.PmItemInfoEntity;
import pmsocspsc.modules.pms.entity.PmTeamInfoEntity;
import pmsocspsc.modules.pms.entity.PmTeamPersonInfoEntity;
import pmsocspsc.modules.pms.service.PmItemInfoService;
import pmsocspsc.modules.pms.service.PmTeamInfoService;
import pmsocspsc.modules.pms.service.PmTeamPersonInfoService;


@Service("pmTeamInfoService")
public class PmTeamInfoServiceImpl extends ServiceImpl<PmTeamInfoDao, PmTeamInfoEntity> implements PmTeamInfoService {

    @Autowired
    private PmTeamPersonInfoService pmTeamPersonInfoService;
    @Autowired
    private PmItemInfoService pmItemInfoService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        QueryWrapper ew = new QueryWrapper<PmTeamInfoEntity>().setEntity(new PmTeamInfoEntity());
        Object teamInfoId = params.get("teamInfoId");
        Object userId = params.get("userId");


        //立项项目id
        if (teamInfoId!=null&&teamInfoId!="")ew.eq("item_info_id",teamInfoId);

        if (userId!=null&&userId!=""){
            List<Integer> param = new ArrayList<>();
            List<PmItemInfoEntity> item = pmItemInfoService.findItemByUserId(Integer.parseInt(userId.toString()));
            item.forEach(v->{ param.add(v.getItemInfoId()); });
            if (item.size()>0)ew.in("item_info_id",param);
        }

        IPage<PmTeamInfoEntity> page = this.page(
                new Query<PmTeamInfoEntity>().getPage(params),
                ew
        );

        return new PageUtils(page);
    }

    @Override
    public List<PmTeamInfoEntity> findByItemId(Integer itemInfoId) {
        return baseMapper.findByItemId(itemInfoId);
    }

    @Override
    public void updateBySimple(PmTeamInfoEntity v) {
        super.updateById(v);
    }

    /**
     * 保存
     * @param entity
     * @return
     */
    @Override
    public boolean save(PmTeamInfoEntity entity) {
        boolean res = super.save(entity);

        entity.getPmTeamPersonInfoEntities().forEach(v->{
            v.setPersonTeamInfoId(entity.getTeamId());
            pmTeamPersonInfoService.save(v);
        });

        return res;
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @Override
    public PmTeamInfoEntity getById(Serializable id) {
        return baseMapper.findById((Integer) id);
    }

    /**
     * 更新
     * @param entity
     * @return
     */
    @Override
    public boolean updateById(PmTeamInfoEntity entity) {
        PmTeamInfoEntity temp = getById(entity.getTeamId());
        temp.getPmTeamPersonInfoEntities().forEach(v->{
            pmTeamPersonInfoService.removeById(v);
        });
        entity.getPmTeamPersonInfoEntities().forEach(v->{
            v.setPersonTeamInfoId(entity.getTeamId());
            pmTeamPersonInfoService.saveOrUpdate(v);
        });
        return super.updateById(entity);
    }
}