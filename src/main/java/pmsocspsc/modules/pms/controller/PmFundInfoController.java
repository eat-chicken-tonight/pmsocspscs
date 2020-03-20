package pmsocspsc.modules.pms.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.R;
import pmsocspsc.modules.pms.entity.PmFundInfoEntity;
import pmsocspsc.modules.pms.service.PmFundInfoService;

import java.util.Arrays;
import java.util.Map;


/**
 * 经费预算/实际支出信息表
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@Api(value = "结题预算",tags = {"结题预算接口"},description = "结题预算")
@RestController
@RequestMapping("pms/pmfundinfo")
public class PmFundInfoController {
    @Autowired
    private PmFundInfoService pmFundInfoService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询",notes = "查询列表")
    @RequestMapping("/list")
    @RequiresPermissions("pms:pmfundinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmFundInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{budgetId}")
    @RequiresPermissions("pms:pmfundinfo:info")
    public R info(@PathVariable("budgetId") Integer budgetId){
		PmFundInfoEntity pmFundInfo = pmFundInfoService.getById(budgetId);

        return R.ok().put("pmFundInfo", pmFundInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("pms:pmfundinfo:save")
    public R save(@RequestBody PmFundInfoEntity pmFundInfo){
		pmFundInfoService.save(pmFundInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("pms:pmfundinfo:update")
    public R update(@RequestBody PmFundInfoEntity pmFundInfo){
		pmFundInfoService.updateById(pmFundInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("pms:pmfundinfo:delete")
    public R delete(@RequestBody Integer[] budgetIds){
		pmFundInfoService.removeByIds(Arrays.asList(budgetIds));

        return R.ok();
    }

}
