package pmsocspsc.modules.pms.dao;

import pmsocspsc.modules.pms.entity.PmTeamPersonInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 团队成员信息
 * 
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@Mapper
public interface PmTeamPersonInfoDao extends BaseMapper<PmTeamPersonInfoEntity> {
	
}
