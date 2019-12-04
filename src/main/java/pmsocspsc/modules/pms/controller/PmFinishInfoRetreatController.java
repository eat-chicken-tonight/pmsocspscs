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

import pmsocspsc.modules.pms.entity.PmFinishInfoRetreatEntity;
import pmsocspsc.modules.pms.service.PmFinishInfoRetreatService;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.R;



/**
 * 结题回退表
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-12-03 16:46:48
 */
@RestController
@RequestMapping("pms/pmfinishinforetreat")
public class PmFinishInfoRetreatController {
    @Autowired
    private PmFinishInfoRetreatService pmFinishInfoRetreatService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("pms:pmfinishinforetreat:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmFinishInfoRetreatService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{retreatId}")
    @RequiresPermissions("pms:pmfinishinforetreat:info")
    public R info(@PathVariable("retreatId") Integer retreatId){
		PmFinishInfoRetreatEntity pmFinishInfoRetreat = pmFinishInfoRetreatService.getById(retreatId);

        return R.ok().put("pmFinishInfoRetreat", pmFinishInfoRetreat);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("pms:pmfinishinforetreat:save")
    public R save(@RequestBody PmFinishInfoRetreatEntity pmFinishInfoRetreat){
		pmFinishInfoRetreatService.save(pmFinishInfoRetreat);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("pms:pmfinishinforetreat:update")
    public R update(@RequestBody PmFinishInfoRetreatEntity pmFinishInfoRetreat){
		pmFinishInfoRetreatService.updateById(pmFinishInfoRetreat);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("pms:pmfinishinforetreat:delete")
    public R delete(@RequestBody Integer[] retreatIds){
		pmFinishInfoRetreatService.removeByIds(Arrays.asList(retreatIds));

        return R.ok();
    }

}
