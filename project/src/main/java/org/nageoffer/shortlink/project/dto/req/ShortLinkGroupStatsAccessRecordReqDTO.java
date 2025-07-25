package org.nageoffer.shortlink.project.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import org.nageoffer.shortlink.project.dao.entity.LinkAccessLogsDO;

@Data
public class ShortLinkGroupStatsAccessRecordReqDTO extends Page<LinkAccessLogsDO> {

    /**
     * 分组标识
     */
    private String gid;

    /**
     * 开始日期
     */
    private String startDate;

    /**
     * 结束日期
     */
    private String endDate;
}