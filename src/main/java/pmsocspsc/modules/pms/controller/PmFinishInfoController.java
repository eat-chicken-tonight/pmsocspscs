package pmsocspsc.modules.pms.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.R;
import pmsocspsc.modules.pms.entity.PmFinishInfoEntity;
import pmsocspsc.modules.pms.service.PmFinishInfoService;

import java.util.Arrays;
import java.util.Map;


/**
 * 结题信息表
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@Api(value = "结题信息",tags = {"结题信息接口"},description = "结题信息")
@RestController
@RequestMapping("pms/pmfinishinfo")
public class PmFinishInfoController {
    @Autowired
    private PmFinishInfoService pmFinishInfoService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询",notes = "查询列表")
    @RequestMapping("/list")
    @RequiresPermissions("pms:pmfinishinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmFinishInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{finishInfoId}")
    @RequiresPermissions("pms:pmfinishinfo:info")
    public R info(@PathVariable("finishInfoId") Integer finishInfoId){
		PmFinishInfoEntity pmFinishInfo = pmFinishInfoService.getById(finishInfoId);

        return R.ok().put("pmFinishInfo", pmFinishInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("pms:pmfinishinfo:save")
    public R save(@RequestBody PmFinishInfoEntity pmFinishInfo){
		pmFinishInfoService.save(pmFinishInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("pms:pmfinishinfo:update")
    public R update(@RequestBody PmFinishInfoEntity pmFinishInfo){
		pmFinishInfoService.updateById(pmFinishInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("pms:pmfinishinfo:delete")
    public R delete(@RequestBody Integer[] finishInfoIds){
		pmFinishInfoService.removeByIds(Arrays.asList(finishInfoIds));

        return R.ok();
    }
    /**
     * 审批
     */
    @RequestMapping("/apply")
    @RequiresPermissions("pms:pmfinishinfo:info")
    public R apply(@RequestParam Map<String, Object> params){
        pmFinishInfoService.apply(params);

        return R.ok();
    }
}
