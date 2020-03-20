package pmsocspsc.modules.pms.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.R;
import pmsocspsc.modules.pms.entity.PmTeamInfoEntity;
import pmsocspsc.modules.pms.service.PmTeamInfoService;

import java.util.Arrays;
import java.util.Map;


/**
 * 团队信息
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@Api(value = "团队信息",tags = {"团队信息接口"},description = "团队信息")
@RestController
@RequestMapping("pms/pmteaminfo")
public class PmTeamInfoController {
    @Autowired
    private PmTeamInfoService pmTeamInfoService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
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
