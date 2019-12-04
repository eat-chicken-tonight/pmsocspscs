package pmsocspsc.modules.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.modules.pms.entity.PmItemInfoRetreatEntity;

import java.util.Map;

/**
 * 项目立项回退表
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
public interface PmItemInfoRetreatService extends IService<PmItemInfoRetreatEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

