package org.nageoffer.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.nageoffer.shortlink.project.dao.entity.ShortLinkDO;
import org.nageoffer.shortlink.project.dto.biz.ShortLinkStatsRecordDTO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkBatchCreateReqDTO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkPageReqDTO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkUpdateReqDTO;
import org.nageoffer.shortlink.project.dto.resq.ShortLinkBatchCreateRespDTO;
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

    /**
     * 分页查询短链接
     * @param requestParam
     * @return
     */

    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);

    /**
     * 统计分组下短链接数量
     * @param requestParam
     * @return
     */
    List<ShortLinkGroupCountQueryRespDTO> countShortLinkByGroup(List<String> requestParam);

    /**
     * 修改短链接
     * @param requestParam
     */

    /**
     * 查询短链接分组内数量
     *
     * @param requestParam 查询短链接分组内数量请求参数
     * @return 查询短链接分组内数量响应
     */
    List<ShortLinkGroupCountQueryRespDTO> listGroupShortLinkCount(List<String> requestParam);

    void updateShortLink(ShortLinkUpdateReqDTO requestParam);

    /**
     * 还原短跳转
     * @param shortUri
     * @param request
     * @param response
     */
    void restoreUrl(String shortUri, ServletRequest request, ServletResponse response);

    /**
     * 批量创建短链接
     *
     * @param requestParam 批量创建短链接请求参数
     * @return 批量创建短链接返回参数
     */
    ShortLinkBatchCreateRespDTO batchCreateShortLink(ShortLinkBatchCreateReqDTO requestParam);

    /**
     * 短链接统计
     *
     * @param fullShortUrl         完整短链接
     * @param gid                  分组标识
     * @param shortLinkStatsRecord 短链接统计实体参数
     */
    void shortLinkStats(String fullShortUrl, String gid, ShortLinkStatsRecordDTO shortLinkStatsRecord);

}
