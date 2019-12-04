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

import pmsocspsc.modules.pms.entity.PmFundInfoEntity;
import pmsocspsc.modules.pms.service.PmFundInfoService;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.R;



/**
 * 经费预算/实际支出信息表
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@RestController
@RequestMapping("pms/pmfundinfo")
public class PmFundInfoController {
    @Autowired
    private PmFundInfoService pmFundInfoService;

    /**
     * 列表
     */
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
