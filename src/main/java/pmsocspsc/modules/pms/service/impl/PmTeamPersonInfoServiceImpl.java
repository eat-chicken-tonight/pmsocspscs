package pmsocspsc.modules.pms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.Query;

import pmsocspsc.modules.pms.dao.PmTeamPersonInfoDao;
import pmsocspsc.modules.pms.entity.PmTeamPersonInfoEntity;
import pmsocspsc.modules.pms.service.PmTeamPersonInfoService;


@Service("pmTeamPersonInfoService")
public class PmTeamPersonInfoServiceImpl extends ServiceImpl<PmTeamPersonInfoDao, PmTeamPersonInfoEntity> implements PmTeamPersonInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmTeamPersonInfoEntity> page = this.page(
                new Query<PmTeamPersonInfoEntity>().getPage(params),
                new QueryWrapper<PmTeamPersonInfoEntity>()
        );

        return new PageUtils(page);
    }

}