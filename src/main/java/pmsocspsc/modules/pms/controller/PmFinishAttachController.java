package pmsocspsc.modules.pms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import pmsocspsc.common.utils.ConfigConstant;
import pmsocspsc.common.utils.FileUtils;
import pmsocspsc.modules.pms.entity.PmFinishAttachEntity;
import pmsocspsc.modules.pms.service.PmFinishAttachService;
import pmsocspsc.common.utils.PageUtils;
import pmsocspsc.common.utils.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 结题附件
 *
 * @author mikey
 * @email biaogejiushibiao@gmail.com
 * @date 2019-11-27 17:34:06
 */
@RestController
@RequestMapping("pms/pmfinishattach")
public class PmFinishAttachController {
    @Autowired
    private PmFinishAttachService pmFinishAttachService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("pms:pmfinishattach:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pmFinishAttachService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attachId}")
    @RequiresPermissions("pms:pmfinishattach:info")
    public R info(@PathVariable("attachId") Integer attachId){
		PmFinishAttachEntity pmFinishAttach = pmFinishAttachService.getById(attachId);

        return R.ok().put("pmFinishAttach", pmFinishAttach);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("pms:pmfinishattach:save")
    public R save(@RequestBody PmFinishAttachEntity pmFinishAttach){
		pmFinishAttachService.save(pmFinishAttach);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("pms:pmfinishattach:update")
    public R update(@RequestBody PmFinishAttachEntity pmFinishAttach){
		pmFinishAttachService.updateById(pmFinishAttach);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("pms:pmfinishattach:delete")
    public R delete(@RequestBody Integer[] attachIds){
		pmFinishAttachService.removeByIds(Arrays.asList(attachIds));

        return R.ok();
    }
    /**
     * 文件上传
     * @param files
     * @param request
     * @return
     */
    @PostMapping(value = "/upload")
    public Object uploadFile(@RequestParam("file") List<MultipartFile> files, HttpServletRequest request) {

        String UPLOAD_FILES_PATH = ConfigConstant.UPLOAD_FILE_SAVE_PATH + "/"+ RandomUtils.nextLong()+"/";

        if (Objects.isNull(files) || files.isEmpty()) {
            return R.error("文件为空，请重新上传");
        }

        PmFinishAttachEntity pmFinishAttachEntity = null;

        for(MultipartFile file : files){
            String fileName = file.getOriginalFilename();
            String result = null;
            try {
                result = FileUtils.upLoad(UPLOAD_FILES_PATH, fileName, file);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!result.equals("true")) {
                R.error(result);
            }
            UPLOAD_FILES_PATH += fileName;
            pmFinishAttachEntity = new PmFinishAttachEntity();
            pmFinishAttachEntity.setAttachName(fileName);
            pmFinishAttachEntity.setAttachPath(UPLOAD_FILES_PATH);
        }
        return R.ok("文件上传成功").put("pmFinishAttachEntity", pmFinishAttachEntity);
    }

    /**
     * 文件下载
     * @param response
     * @param request
     */
    @PostMapping(value = "/download")
    public void downloadFile(final HttpServletResponse response, final HttpServletRequest request) {
        String filePath = request.getParameter("filePath");
        FileUtils.download(response, filePath);
    }
}
