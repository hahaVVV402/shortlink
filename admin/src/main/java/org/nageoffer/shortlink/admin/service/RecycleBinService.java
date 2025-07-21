package org.nageoffer.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.nageoffer.shortlink.admin.common.convention.result.Result;
import org.nageoffer.shortlink.admin.remote.dto.req.ShortLinkRecyclePageReqDTO;
import org.nageoffer.shortlink.admin.remote.dto.resq.ShortLinkPageRespDTO;

/**
 * URL回收站接口层
 */
public interface RecycleBinService {
    Result<Page<ShortLinkPageRespDTO>>  pageRecycleBinShortLink(ShortLinkRecyclePageReqDTO requestParam);
}
