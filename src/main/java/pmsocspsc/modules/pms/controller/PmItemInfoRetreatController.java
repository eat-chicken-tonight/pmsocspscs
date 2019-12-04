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

import pmsocspsc.modules.pms.entity.PmItemInfoRetreatEntity;
import pmsocspsc.modules.pms.service.PmItemInfoRetreatService;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.R;



/**
 * 项目立项回退表
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@RestController
@RequestMapping("pms/pmiteminforetreat")
public class PmItemInfoRetreatController {
    @Autowired
    private PmItemInfoRetreatService pmItemInfoRetreatService;

    /**
     * 列表
     */
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
