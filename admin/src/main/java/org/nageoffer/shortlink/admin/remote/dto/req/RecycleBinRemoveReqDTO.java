package org.nageoffer.shortlink.admin.remote.dto.req;

import lombok.Data;

/**
 * 回收站删除请求参数
 */
@Data
public class RecycleBinRemoveReqDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 短链接标识
     */
    private String fullShortUrl;
}
