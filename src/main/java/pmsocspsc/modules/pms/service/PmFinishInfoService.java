package pmsocspsc.modules.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.modules.pms.entity.PmFinishInfoEntity;

import java.util.Map;

/**
 * 结题信息表
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
public interface PmFinishInfoService extends IService<PmFinishInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void apply(Map<String, Object> params);
}

