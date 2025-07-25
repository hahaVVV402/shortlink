package org.nageoffer.shortlink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.nageoffer.shortlink.project.common.convention.result.Result;
import org.nageoffer.shortlink.project.common.convention.result.Results;
import org.nageoffer.shortlink.project.dto.req.RecycleBinRecoverReqDTO;
import org.nageoffer.shortlink.project.dto.req.RecycleBinRemoveReqDTO;
import org.nageoffer.shortlink.project.dto.req.RecycleBinSaveReqDTO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkRecycleBinPageReqDTO;
import org.nageoffer.shortlink.project.dto.resq.ShortLinkPageRespDTO;
import org.nageoffer.shortlink.project.service.RecycleBinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 回收站管理控制层
 */
@RestController
@RequiredArgsConstructor
public class RecycleBinController {

    private final RecycleBinService recycleBinService;
    /**
     * 保存回收站数据
     *
     * @param requestParam 回收站保存请求参数
     * @return 操作结果
     */
    @PostMapping("/api/short-link/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam){
        recycleBinService.saveRecycleBin(requestParam);
        return Results.success();
    }

    /**
     * 分页查询短链接
     * @param requestParam
     * @return
     */
    @GetMapping("/api/short-link/v1/recycle-bin/page")
    public Result<IPage<ShortLinkPageRespDTO>>  pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam) {
        IPage<ShortLinkPageRespDTO> page = recycleBinService.pageShortLink(requestParam);
        return Results.success(page);
    }

    /**
     * 恢复短链接
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/v1/recycle-bin/recover")
    public Result<Void> recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam) {
        recycleBinService.recoverRecoverBin(requestParam);
        return Results.success();
    }

    /**
     * 删除短链接
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/v1/recycle-bin/remove")
    public Result<Void> removeRecycleBin(@RequestBody RecycleBinRemoveReqDTO requestParam) {
        recycleBinService.removeRecycleBin(requestParam);
        return Results.success();
    }
}
