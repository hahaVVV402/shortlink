package org.nageoffer.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.nageoffer.shortlink.project.dao.entity.ShortLinkDO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkPageReqDTO;
import org.nageoffer.shortlink.project.dto.resq.ShortLinkCreateRespDTO;
import org.nageoffer.shortlink.project.dto.resq.ShortLinkGroupCountQueryRespDTO;
import org.nageoffer.shortlink.project.dto.resq.ShortLinkPageRespDTO;

import java.util.List;

/**
 * 短链接服务接口
 */
public interface ShortLinkService extends IService<ShortLinkDO> {

    /**
     * 创建短链接
     * @param requestParam 短链接创建请求参数
     * @return 短链接创建响应结果
     */
    ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam);

    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);

    /**
     * 统计分组下短链接数量
     * @param requestParam
     * @return
     */
    List<ShortLinkGroupCountQueryRespDTO> countShortLinkByGroup(List<String> requestParam);
}
