package org.nageoffer.shortlink.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.nageoffer.shortlink.project.common.convention.result.Result;
import org.nageoffer.shortlink.project.common.convention.result.Results;
import org.nageoffer.shortlink.project.dto.req.ShortLinkGroupStatsReqDTO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import org.nageoffer.shortlink.project.dto.resq.ShortLinkStatsAccessRecordRespDTO;
import org.nageoffer.shortlink.project.dto.resq.ShortLinkStatsRespDTO;
import org.nageoffer.shortlink.project.service.ShortLinkStatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShortLinkStatsController {

    private final ShortLinkStatsService shortLinkStatsService;

    /**
     * 访问单个短链接指定时间内监控数据
     */
    @GetMapping("/api/short-link/v1/stats")
    public Result<ShortLinkStatsRespDTO> shortLinkStats(ShortLinkStatsReqDTO requestParam) {
        return Results.success(shortLinkStatsService.oneShortLinkStats(requestParam));
    }

    /**
     * 访问单个短链接指定时间内访问记录监控数据
     * @param requestParam
     * @return
     */
    @GetMapping("/api/short-link/v1/stats/access-record")
    public Result<IPage<ShortLinkStatsAccessRecordRespDTO>> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam) {
        return Results.success(shortLinkStatsService.shortLinkStatsAccessRecord(requestParam));
    }

    /**
     * 访问分组短链接指定时间内监控数据
     */
    @GetMapping("/api/short-link/v1/stats/group")
    public Result<ShortLinkStatsRespDTO> groupShortLinkStats(ShortLinkGroupStatsReqDTO requestParam) {
        return Results.success(shortLinkStatsService.groupShortLinkStats(requestParam));
    }


}
