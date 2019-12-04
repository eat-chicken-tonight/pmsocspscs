package pmsocspsc.modules.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.modules.pms.entity.PmFundInfoEntity;

import java.util.Map;

/**
 * 经费预算/实际支出信息表
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
public interface PmFundInfoService extends IService<PmFundInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PmFundInfoEntity findByItemInfoId(Integer itemInfoId);
}

