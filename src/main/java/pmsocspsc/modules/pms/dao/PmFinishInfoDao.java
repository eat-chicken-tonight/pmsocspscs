package pmsocspsc.modules.pms.dao;

import pmsocspsc.modules.pms.entity.PmFinishInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 结题信息表
 * 
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@Mapper
public interface PmFinishInfoDao extends BaseMapper<PmFinishInfoEntity> {
	
}
