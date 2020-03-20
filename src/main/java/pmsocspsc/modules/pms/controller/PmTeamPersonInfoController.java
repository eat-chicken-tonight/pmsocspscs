package pmsocspsc.modules.pms.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.R;
import pmsocspsc.modules.pms.entity.PmTeamPersonInfoEntity;
import pmsocspsc.modules.pms.service.PmTeamPersonInfoService;

import java.util.Arrays;
import java.util.Map;


/**
 * 团队成员信息
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@Api(value = "成员信息",tags = {"成员信息接口"},description = "成员信息")
@RestController
@RequestMapping("pms/pmteampersoninfo")
public class PmTeamPersonInfoController {
    @Autowired
    private PmTeamPersonInfoService pmTeamPersonInfoService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @RequestMapping("/list")
    @RequiresPermissions("pms:pmteampersoninfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmTeamPersonInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查询成员")
    @ApiImplicitParam(name = "成员Id",required = true,dataType = "Long")
    @RequestMapping("/info/{personInfoId}")
    @RequiresPermissions("pms:pmteampersoninfo:info")
    public R info(@PathVariable("personInfoId") Integer personInfoId){
		PmTeamPersonInfoEntity pmTeamPersonInfo = pmTeamPersonInfoService.getById(personInfoId);

        return R.ok().put("pmTeamPersonInfo", pmTeamPersonInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("pms:pmteampersoninfo:save")
    public R save(@RequestBody PmTeamPersonInfoEntity pmTeamPersonInfo){
		pmTeamPersonInfoService.save(pmTeamPersonInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("pms:pmteampersoninfo:update")
    public R update(@RequestBody PmTeamPersonInfoEntity pmTeamPersonInfo){
		pmTeamPersonInfoService.updateById(pmTeamPersonInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("pms:pmteampersoninfo:delete")
    public R delete(@RequestBody Integer[] personInfoIds){
		pmTeamPersonInfoService.removeByIds(Arrays.asList(personInfoIds));

        return R.ok();
    }

}
