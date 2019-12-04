package pmsocspsc.modules.pms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 结题附件
 * 
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@Data
@TableName("pm_finish_attach")
public class PmFinishAttachEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer attachId;
	/**
	 * 结题id
	 */
	private Integer finishInfoId;
	/**
	 * 附件名称
	 */
	private String attachName;
	/**
	 * 附件路径
	 */
	private String attachPath;
	/**
	 * 删除标识
	 */
	private Integer attachIsDel;

}
