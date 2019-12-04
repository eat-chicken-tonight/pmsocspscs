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

import pmsocspsc.modules.pms.entity.PmItemInfoEntity;
import pmsocspsc.modules.pms.service.PmItemInfoService;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.R;



/**
 * 项目立项申请表
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@RestController
@RequestMapping("pms/pmiteminfo")
public class PmItemInfoController {
    @Autowired
    private PmItemInfoService pmItemInfoService;

    /**
     * 列表
     */
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
