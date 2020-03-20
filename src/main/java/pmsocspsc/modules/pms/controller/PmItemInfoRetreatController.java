package pmsocspsc.modules.pms.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.R;
import pmsocspsc.modules.pms.entity.PmItemInfoRetreatEntity;
import pmsocspsc.modules.pms.service.PmItemInfoRetreatService;

import java.util.Arrays;
import java.util.Map;


/**
 * 项目立项回退表
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@Api(value = "项目回退",tags = {"项目回退接口"},description = "项目回退")
@RestController
@RequestMapping("pms/pmiteminforetreat")
public class PmItemInfoRetreatController {
    @Autowired
    private PmItemInfoRetreatService pmItemInfoRetreatService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @RequestMapping("/list")
    @RequiresPermissions("pms:pmiteminforetreat:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmItemInfoRetreatService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{retreatId}")
    @RequiresPermissions("pms:pmiteminforetreat:info")
    public R info(@PathVariable("retreatId") Integer retreatId){
		PmItemInfoRetreatEntity pmItemInfoRetreat = pmItemInfoRetreatService.getById(retreatId);

        return R.ok().put("pmItemInfoRetreat", pmItemInfoRetreat);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("pms:pmiteminforetreat:save")
    public R save(@RequestBody PmItemInfoRetreatEntity pmItemInfoRetreat){
		pmItemInfoRetreatService.save(pmItemInfoRetreat);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("pms:pmiteminforetreat:update")
    public R update(@RequestBody PmItemInfoRetreatEntity pmItemInfoRetreat){
		pmItemInfoRetreatService.updateById(pmItemInfoRetreat);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("pms:pmiteminforetreat:delete")
    public R delete(@RequestBody Integer[] retreatIds){
		pmItemInfoRetreatService.removeByIds(Arrays.asList(retreatIds));

        return R.ok();
    }

}
