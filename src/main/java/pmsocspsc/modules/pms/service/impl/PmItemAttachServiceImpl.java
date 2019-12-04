package pmsocspsc.modules.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.Query;

import pmsocspsc.modules.pms.dao.PmItemAttachDao;
import pmsocspsc.modules.pms.entity.PmFundInfoEntity;
import pmsocspsc.modules.pms.entity.PmItemAttachEntity;
import pmsocspsc.modules.pms.service.PmItemAttachService;


@Service("pmItemAttachService")
public class PmItemAttachServiceImpl extends ServiceImpl<PmItemAttachDao, PmItemAttachEntity> implements PmItemAttachService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmItemAttachEntity> page = this.page(
                new Query<PmItemAttachEntity>().getPage(params),
                new QueryWrapper<PmItemAttachEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PmItemAttachEntity findByItemInfoId(Integer itemInfoId) {

        QueryWrapper ew = new QueryWrapper<PmItemAttachEntity>().setEntity(new PmItemAttachEntity());

        ew.eq("item_info_id", itemInfoId);

        return super.getOne(ew);
    }

}