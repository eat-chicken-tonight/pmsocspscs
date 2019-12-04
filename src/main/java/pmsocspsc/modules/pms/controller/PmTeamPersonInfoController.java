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

import pmsocspsc.modules.pms.entity.PmTeamPersonInfoEntity;
import pmsocspsc.modules.pms.service.PmTeamPersonInfoService;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.R;



/**
 * 团队成员信息
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@RestController
@RequestMapping("pms/pmteampersoninfo")
public class PmTeamPersonInfoController {
    @Autowired
    private PmTeamPersonInfoService pmTeamPersonInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("pms:pmteampersoninfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmTeamPersonInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
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
