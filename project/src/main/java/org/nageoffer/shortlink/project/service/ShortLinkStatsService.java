package org.nageoffer.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.nageoffer.shortlink.project.dto.req.ShortLinkGroupStatsAccessRecordReqDTO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkGroupStatsReqDTO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import org.nageoffer.shortlink.project.dto.resq.ShortLinkStatsAccessRecordRespDTO;
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

    /**
     * 获取分组短链接监控数据
     * @param requestParam
     * @return
     */
      IPage<ShortLinkStatsAccessRecordRespDTO> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam);

    /**
     * 获取分组短链接监控数据
     *
     * @param requestParam 获取分组短链接监控数据入参
     * @return 分组短链接监控数据
     */
    ShortLinkStatsRespDTO groupShortLinkStats(ShortLinkGroupStatsReqDTO requestParam);

    /**
     * 获取分组短链接访问记录监控数据
     * @param requestParam
     * @return
     */
    IPage<ShortLinkStatsAccessRecordRespDTO> groupShortLinkStatsAccessRecord(ShortLinkGroupStatsAccessRecordReqDTO requestParam);
}
