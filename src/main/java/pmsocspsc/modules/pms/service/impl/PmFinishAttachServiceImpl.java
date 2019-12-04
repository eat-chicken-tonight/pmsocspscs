package pmsocspsc.modules.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.Query;

import pmsocspsc.modules.pms.dao.PmFinishAttachDao;
import pmsocspsc.modules.pms.entity.PmFinishAttachEntity;
import pmsocspsc.modules.pms.service.PmFinishAttachService;


@Service("pmFinishAttachService")
public class PmFinishAttachServiceImpl extends ServiceImpl<PmFinishAttachDao, PmFinishAttachEntity> implements PmFinishAttachService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmFinishAttachEntity> page = this.page(
                new Query<PmFinishAttachEntity>().getPage(params),
                new QueryWrapper<PmFinishAttachEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PmFinishAttachEntity findByFinishId(Integer finishInfoId) {
        return baseMapper.findByFinishId(finishInfoId);
    }

}