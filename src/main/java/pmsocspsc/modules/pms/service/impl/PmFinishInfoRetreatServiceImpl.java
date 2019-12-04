package pmsocspsc.modules.pms.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.Query;

import pmsocspsc.modules.pms.dao.PmFinishInfoRetreatDao;
import pmsocspsc.modules.pms.entity.PmFinishInfoRetreatEntity;
import pmsocspsc.modules.pms.service.PmFinishInfoRetreatService;


@Service("pmFinishInfoRetreatService")
public class PmFinishInfoRetreatServiceImpl extends ServiceImpl<PmFinishInfoRetreatDao, PmFinishInfoRetreatEntity> implements PmFinishInfoRetreatService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper ew = new QueryWrapper<PmFinishInfoRetreatEntity>();
        ew.setEntity(new PmFinishInfoRetreatEntity());
        ew.eq("retreat_is_del",0);
        ew.eq("finish_info_id",params.get("finishInfoId"));
        return new PageUtils(new Page<PmFinishInfoRetreatEntity>().setRecords(this.list(ew)));
    }

}