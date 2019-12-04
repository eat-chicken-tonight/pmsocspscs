package pmsocspsc.modules.pms.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pmsocspsc.modules.pms.entity.PmTeamInfoEntity;
import pmsocspsc.modules.pms.service.PmTeamInfoService;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.R;



/**
 * 团队信息
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@RestController
@RequestMapping("pms/pmteaminfo")
public class PmTeamInfoController {
    @Autowired
    private PmTeamInfoService pmTeamInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("pms:pmteaminfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmTeamInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{teamId}")
    @RequiresPermissions("pms:pmteaminfo:info")
    public R info(@PathVariable("teamId") Integer teamId){
		PmTeamInfoEntity pmTeamInfo = pmTeamInfoService.getById(teamId);

        return R.ok().put("pmTeamInfo", pmTeamInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("pms:pmteaminfo:save")
    public R save(@RequestBody PmTeamInfoEntity pmTeamInfo){
		pmTeamInfoService.save(pmTeamInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("pms:pmteaminfo:update")
    public R update(@RequestBody PmTeamInfoEntity pmTeamInfo){
		pmTeamInfoService.updateById(pmTeamInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("pms:pmteaminfo:delete")
    public R delete(@RequestBody Integer[] teamIds){
		pmTeamInfoService.removeByIds(Arrays.asList(teamIds));

        return R.ok();
    }

}
