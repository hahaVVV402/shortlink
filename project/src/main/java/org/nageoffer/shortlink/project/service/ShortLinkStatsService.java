package org.nageoffer.shortlink.project.service;

import org.nageoffer.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import org.nageoffer.shortlink.project.dto.resq.ShortLinkStatsRespDTO;

/**
 * 短链接监控接口层
 */
public interface ShortLinkStatsService {

    /**
     * 获取单个短链接监控数据
     *
     * @param requestParam 获取短链接监控数据入参
     * @return 短链接监控数据
     */
    ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam);
}
