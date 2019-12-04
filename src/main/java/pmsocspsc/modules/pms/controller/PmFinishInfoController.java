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

import pmsocspsc.modules.pms.entity.PmFinishInfoEntity;
import pmsocspsc.modules.pms.service.PmFinishInfoService;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.R;



/**
 * 结题信息表
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@RestController
@RequestMapping("pms/pmfinishinfo")
public class PmFinishInfoController {
    @Autowired
    private PmFinishInfoService pmFinishInfoService;

    /**
     * 列表
     */
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
