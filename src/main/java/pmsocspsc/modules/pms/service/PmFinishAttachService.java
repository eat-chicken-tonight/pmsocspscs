package pmsocspsc.modules.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.modules.pms.entity.PmFinishAttachEntity;

import java.util.Map;

/**
 * 结题附件
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
public interface PmFinishAttachService extends IService<PmFinishAttachEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PmFinishAttachEntity findByFinishId(Integer finishInfoId);
}

