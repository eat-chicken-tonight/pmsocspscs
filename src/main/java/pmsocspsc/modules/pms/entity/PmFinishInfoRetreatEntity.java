package pmsocspsc.modules.pms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 结题回退表
 * 
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-12-03 16:46:48
 */
@Data
@TableName("pm_finish_info_retreat")
public class PmFinishInfoRetreatEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer retreatId;
	/**
	 * 结题申请Id
	 */
	private Integer finishInfoId;
	/**
	 * 回退意见
	 */
	private String retreatAdvise;
	/**
	 * 删除标识
	 */
	private Integer retreatIsDel;

}
