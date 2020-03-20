package pmsocspsc.modules.pms.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.R;
import pmsocspsc.modules.pms.entity.PmItemInfoEntity;
import pmsocspsc.modules.pms.service.PmItemInfoService;

import java.util.Arrays;
import java.util.Map;


/**
 * 项目立项申请表
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@Api(value = "项目信息",tags = {"项目信息接口"},description = "项目信息")
@RestController
@RequestMapping("pms/pmiteminfo")
public class PmItemInfoController {
    @Autowired
    private PmItemInfoService pmItemInfoService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询",notes = "查询列表")
    @RequestMapping("/list")
    @RequiresPermissions("pms:pmiteminfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmItemInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{itemInfoId}")
    @RequiresPermissions("pms:pmiteminfo:info")
    public R info(@PathVariable("itemInfoId") Integer itemInfoId){

        PmItemInfoEntity pmItemInfo = pmItemInfoService.getById(itemInfoId);

        return R.ok().put("pmItemInfo", pmItemInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("pms:pmiteminfo:save")
    public R save(@RequestBody PmItemInfoEntity pmItemInfo){
		pmItemInfoService.save(pmItemInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("pms:pmiteminfo:update")
    public R update(@RequestBody PmItemInfoEntity pmItemInfo){
		pmItemInfoService.updateById(pmItemInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("pms:pmiteminfo:delete")
    public R delete(@RequestBody Integer[] itemInfoIds){

		pmItemInfoService.removeByIds(Arrays.asList(itemInfoIds));

        return R.ok();
    }
    /**
     * 删除
     */
    @RequestMapping("/apply")
    @RequiresPermissions("pms:pmiteminfo:info")
    public R apply(@RequestParam Map<String, Object> params){

        pmItemInfoService.apply(params);

        return R.ok();
    }
}
