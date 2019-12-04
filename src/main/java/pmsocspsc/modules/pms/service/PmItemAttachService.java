package pmsocspsc.modules.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.modules.pms.entity.PmItemAttachEntity;

import java.util.Map;

/**
 * 附件表
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
public interface PmItemAttachService extends IService<PmItemAttachEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PmItemAttachEntity findByItemInfoId(Integer itemInfoId);
}

