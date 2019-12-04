package pmsocspsc.modules.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.modules.pms.entity.PmItemInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 项目立项申请表
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
public interface PmItemInfoService extends IService<PmItemInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void apply(Map<String, Object> params);

    List<PmItemInfoEntity> findItemByUserId(Integer userId);

    void updateBySimle(PmItemInfoEntity itemInfoEntity);
}

