package pmsocspsc.modules.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.modules.pms.entity.PmTeamInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 团队信息
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
public interface PmTeamInfoService extends IService<PmTeamInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<PmTeamInfoEntity> findByItemId(Integer itemInfoId);

    void updateBySimple(PmTeamInfoEntity v);
}

