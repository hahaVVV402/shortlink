package org.nageoffer.shortlink.admin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.nageoffer.shortlink.admin.common.convention.result.Result;
import org.nageoffer.shortlink.admin.common.convention.result.Results;
import org.nageoffer.shortlink.admin.remote.ShortLinkActualRemoteService;
import org.nageoffer.shortlink.admin.remote.dto.req.ShortLinkBatchCreateReqDTO;
import org.nageoffer.shortlink.admin.remote.dto.req.ShortLinkCreateReqDTO;
import org.nageoffer.shortlink.admin.remote.dto.req.ShortLinkPageReqDTO;
import org.nageoffer.shortlink.admin.remote.dto.req.ShortLinkUpdateReqDTO;
import org.nageoffer.shortlink.admin.remote.dto.resq.ShortLinkBaseInfoRespDTO;
import org.nageoffer.shortlink.admin.remote.dto.resq.ShortLinkBatchCreateRespDTO;
import org.nageoffer.shortlink.admin.remote.dto.resq.ShortLinkCreateRespDTO;
import org.nageoffer.shortlink.admin.remote.dto.resq.ShortLinkPageRespDTO;
import org.nageoffer.shortlink.admin.toolkit.EasyExcelWebUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 短链接后管控制层
 */
@RestController(value = "shortLinkControllerByAdmin")
@RequiredArgsConstructor
public class ShortLinkController {

    private final ShortLinkActualRemoteService shortLinkActualRemoteService;

    /**
     * 创建短链接
     *
     * @param requestParam 短链接创建请求参数
     * @return 短链接创建响应结果
     */
    @PostMapping("/api/short-link/admin/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return shortLinkActualRemoteService.createShortLink(requestParam);
    }

    /**
     * 批量创建短链接
     */
    @SneakyThrows
    @PostMapping("/api/short-link/admin/v1/create/batch")
    public void batchCreateShortLink(@RequestBody ShortLinkBatchCreateReqDTO requestParam, HttpServletResponse response) {
        Result<ShortLinkBatchCreateRespDTO> shortLinkBatchCreateRespDTOResult = shortLinkActualRemoteService.batchCreateShortLink(requestParam);
        if (shortLinkBatchCreateRespDTOResult.isSuccess()) {
            List<ShortLinkBaseInfoRespDTO> baseLinkInfos = shortLinkBatchCreateRespDTOResult.getData().getBaseLinkInfos();
            EasyExcelWebUtil.write(response, "批量创建短链接-SaaS短链接系统", ShortLinkBaseInfoRespDTO.class, baseLinkInfos);
        }
    }

    /**
     * 修改短链接
     */
    @PostMapping("/api/short-link/admin/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam) {
        shortLinkActualRemoteService.updateShortLink(requestParam);
        return Results.success();
    }

    /**
     * 分页查询短链接
     *
     * @param requestParam
     * @return
     */
    @GetMapping("/api/short-link/admin/v1/page")
    public Result<Page<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return shortLinkActualRemoteService.pageShortLink(requestParam.getGid(),
                requestParam.getOrderTag(),
                requestParam.getCurrent(),
                requestParam.getSize());
    }


}
