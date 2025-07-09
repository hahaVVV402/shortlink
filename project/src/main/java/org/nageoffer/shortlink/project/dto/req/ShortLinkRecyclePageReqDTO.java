package org.nageoffer.shortlink.project.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import org.nageoffer.shortlink.project.dao.entity.ShortLinkDO;

import java.util.List;

/**
 * 短链接分页请求参数
 */
@Data
public class ShortLinkRecyclePageReqDTO extends Page<ShortLinkDO> {

    /**
     * 分组标识
     */
    private List<String> gidList;

}
