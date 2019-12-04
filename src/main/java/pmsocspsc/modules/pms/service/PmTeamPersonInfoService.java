package pmsocspsc.modules.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.modules.pms.entity.PmTeamPersonInfoEntity;

import java.util.Map;

/**
 * 团队成员信息
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
public interface PmTeamPersonInfoService extends IService<PmTeamPersonInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

