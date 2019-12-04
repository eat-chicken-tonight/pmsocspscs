package pmsocspsc.modules.pms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 团队成员信息
 * 
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@Data
@TableName("pm_team_person_info")
public class PmTeamPersonInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer personInfoId;
	/**
	 * 团队id
	 */
	private Integer personTeamInfoId;
	/**
	 * 学号
	 */
	private String personCode;
	/**
	 * 姓名
	 */
	private String personName;
	/**
	 * 学院
	 */
	private String personInstitute;
	/**
	 * 班级
	 */
	private String personClass;
	/**
	 * 年级
	 */
	private String personGrade;
	/**
	 * 专业
	 */
	private String personMajor;
	/**
	 * 邮箱
	 */
	private String personEmail;
	/**
	 * 电话
	 */
	private String personPhone;
	/**
	 * 删除标识
	 */
	private Integer personInfoIsDel;

}
