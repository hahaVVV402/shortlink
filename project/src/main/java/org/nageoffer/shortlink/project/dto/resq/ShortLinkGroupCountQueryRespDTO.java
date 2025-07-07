package org.nageoffer.shortlink.project.dto.resq;

import lombok.Data;

/**
 * 短链接分组统计查询响应DTO
 * 用于返回短链接分组的统计信息
 */
@Data
public class ShortLinkGroupCountQueryRespDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private Integer shortLinkCount;
}
