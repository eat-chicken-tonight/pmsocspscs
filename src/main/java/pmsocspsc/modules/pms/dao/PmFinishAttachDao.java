package pmsocspsc.modules.pms.dao;

import pmsocspsc.modules.pms.entity.PmFinishAttachEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 结题附件
 * 
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@Mapper
public interface PmFinishAttachDao extends BaseMapper<PmFinishAttachEntity> {

    /**
     * 通过结题id查询对应的附件
     * @param finishInfoId
     * @return
     */
    PmFinishAttachEntity findByFinishId(Integer finishInfoId);
}
