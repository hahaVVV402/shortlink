package org.nageoffer.shortlink.project.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.RequiredArgsConstructor;
import org.nageoffer.shortlink.project.common.convention.result.Result;
import org.nageoffer.shortlink.project.common.convention.result.Results;
import org.nageoffer.shortlink.project.dto.req.ShortLinkBatchCreateReqDTO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkPageReqDTO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkUpdateReqDTO;
import org.nageoffer.shortlink.project.dto.resq.ShortLinkBatchCreateRespDTO;
import org.nageoffer.shortlink.project.dto.resq.ShortLinkCreateRespDTO;
import org.nageoffer.shortlink.project.dto.resq.ShortLinkGroupCountQueryRespDTO;
import org.nageoffer.shortlink.project.dto.resq.ShortLinkPageRespDTO;
import org.nageoffer.shortlink.project.handler.CustomBlockHandler;
import org.nageoffer.shortlink.project.service.ShortLinkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 短链接控制层
 */
@RequiredArgsConstructor
@RestController
public class ShortLinkController {

    private final ShortLinkService shortLinkService;

    @GetMapping("/{short-uri}")
    public void restoreUrl(@PathVariable("short-uri") String shortUri, ServletRequest request, ServletResponse response) {
        shortLinkService.restoreUrl(shortUri,request,response);
    }

    /**
     * 创建短链接
     * @param requestParam 短链接创建请求参数
     * @return 短链接创建响应结果
     */
    @PostMapping("/api/short-link/v1/create")
    @SentinelResource(
            value = "create_short-link",
            blockHandler = "createShortLinkBlockHandler",
            blockHandlerClass = CustomBlockHandler.class
    )
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam){
        return Results.success(shortLinkService.createShortLink(requestParam));
    }

    /**
     * 修改短链接
     * @param requestParam
     * @return
     *
     *
     *     "describe": "incididunt culpa tempor aliqua"
     */
    @PostMapping("/api/short-link/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam) {
        shortLinkService.updateShortLink(requestParam);
        return Results.success();
    }
    /**
     * 分页查询短链接
     * @param requestParam 短链接分页查询请求参数
     * @return 短链接分页查询响应结果
     */
    @GetMapping("/api/short-link/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>>  pageShortLink(ShortLinkPageReqDTO requestParam) {
        IPage<ShortLinkPageRespDTO> page = shortLinkService.pageShortLink(requestParam);
        return Results.success(page);
    }

    /**
     * 统计分组下短链接数量
     * @return
     */
    @GetMapping("/api/short-link/v1/count")
    public Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLinkCount(@RequestParam List<String> requestParam) {
        List<ShortLinkGroupCountQueryRespDTO> list = shortLinkService.countShortLinkByGroup(requestParam);
        return Results.success(list);
    }

    /**
     * 批量创建短链接
     */
    @PostMapping("/api/short-link/v1/create/batch")
    public Result<ShortLinkBatchCreateRespDTO> batchCreateShortLink(@RequestBody ShortLinkBatchCreateReqDTO requestParam) {
        return Results.success(shortLinkService.batchCreateShortLink(requestParam));
    }

}
