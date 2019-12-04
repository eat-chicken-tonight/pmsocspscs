package pmsocspsc.modules.pms.service.impl;

import com.baomidou.mybatisplus.core.enums.SqlLike;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.Query;

import pmsocspsc.modules.pms.dao.PmItemInfoRetreatDao;
import pmsocspsc.modules.pms.entity.PmItemInfoRetreatEntity;
import pmsocspsc.modules.pms.service.PmItemInfoRetreatService;


@Service("pmItemInfoRetreatService")
public class PmItemInfoRetreatServiceImpl extends ServiceImpl<PmItemInfoRetreatDao, PmItemInfoRetreatEntity> implements PmItemInfoRetreatService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper ew = new QueryWrapper<PmItemInfoRetreatEntity>();
        ew.setEntity(new PmItemInfoRetreatEntity());
        ew.eq("retreat_is_del",0);
        ew.eq("item_info_id",params.get("itemInfoId"));
        return new PageUtils(new Page<PmItemInfoRetreatEntity>().setRecords(this.list(ew)));
    }

}