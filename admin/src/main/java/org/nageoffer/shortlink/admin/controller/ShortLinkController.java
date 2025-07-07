package org.nageoffer.shortlink.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.nageoffer.shortlink.admin.common.convention.result.Result;
import org.nageoffer.shortlink.admin.common.convention.result.Results;
import org.nageoffer.shortlink.admin.remote.ShorLinkRemoteService;
import org.nageoffer.shortlink.admin.remote.dto.req.ShortLinkCreateReqDTO;
import org.nageoffer.shortlink.admin.remote.dto.req.ShortLinkPageReqDTO;
import org.nageoffer.shortlink.admin.remote.dto.req.ShortLinkUpdateReqDTO;
import org.nageoffer.shortlink.admin.remote.dto.resq.ShortLinkCreateRespDTO;
import org.nageoffer.shortlink.admin.remote.dto.resq.ShortLinkPageRespDTO;
import org.springframework.web.bind.annotation.*;

/**
 * 短链接后管控制层
 */
@RestController
public class ShortLinkController {

    /**
     * 后续重构为SpringCloud Feign 调用
     */
    ShorLinkRemoteService shortLinkRemoteService = new ShorLinkRemoteService() {
    };

    /**
     * 创建短链接
     *
     * @param requestParam 短链接创建请求参数
     * @return 短链接创建响应结果
     */
    @PostMapping("/api/short-link/admin/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam){
        return shortLinkRemoteService.createShortLink(requestParam);
    }

    /**
     * 分页查询短链接
     * @param requestParam
     * @return
     */
    @GetMapping("/api/short-link/admin/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return shortLinkRemoteService.pageShortLink(requestParam);
    }

    /**
     * 修改短链接
     * @param requestParam
     * @return
     */
    @PutMapping("/api/short-link/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam) {
        shortLinkRemoteService.updateShortLink(requestParam);
        return Results.success();
    }
}
