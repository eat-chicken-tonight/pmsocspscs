package pmsocspsc.modules.pms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 结题信息表
 * 
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@Data
@TableName("pm_finish_info")
public class PmFinishInfoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Id
	 */
	@TableId
	private Integer finishInfoId;
	/**
	 * 立项项目id
	 */
	private Integer itemInfoId;
	/**
	 * 审核状态
	 */
	private Integer finishInfoStatus;
	/**
	 * 结题人
	 */
	private Integer userId;
	/**
	 * 删除标识
	 */
	private Integer finishIsDel;
	/**
	 * 对应的立项项目
	 */
	@TableField(exist = false)
	private PmItemInfoEntity pmItemInfoEntity;
	/**
	 * 参赛队伍
	 */
	@TableField(exist = false)
	List<PmTeamInfoEntity> pmTeamInfoEntities;
	/**
	 * 实际预算
	 */
	@TableField(exist = false)
	private PmFundInfoEntity pmFundInfoEntity;
	/**
	 * 结题报告书
	 */
	@TableField(exist = false)
	private PmFinishAttachEntity pmFinishAttachEntity;

}
