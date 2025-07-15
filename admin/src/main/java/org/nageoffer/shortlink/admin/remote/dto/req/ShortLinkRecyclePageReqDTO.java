package org.nageoffer.shortlink.admin.remote.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * 短链接分页请求参数
 */
@Data
public class ShortLinkRecyclePageReqDTO extends Page {

    /**
     * 分组标识
     */
    private List<String> gidList;

    /**
     * 排序标识
     */
    private  String orderTag;
}
