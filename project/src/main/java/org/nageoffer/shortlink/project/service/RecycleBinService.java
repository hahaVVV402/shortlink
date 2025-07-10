package org.nageoffer.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.nageoffer.shortlink.project.dao.entity.ShortLinkDO;
import org.nageoffer.shortlink.project.dto.req.RecycleBinRecoverReqDTO;
import org.nageoffer.shortlink.project.dto.req.RecycleBinRemoveReqDTO;
import org.nageoffer.shortlink.project.dto.req.RecycleBinSaveReqDTO;
import org.nageoffer.shortlink.project.dto.req.ShortLinkRecyclePageReqDTO;
import org.nageoffer.shortlink.project.dto.resq.ShortLinkPageRespDTO;

/**
 * 回收站服务接口
 */
public interface RecycleBinService extends IService<ShortLinkDO> {
    /**
     * 保存回收站数据
     * @param requestParam
     */
    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);
    /**
     * 分页查询短链接
     * @param requestParam
     * @return
     */

    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkRecyclePageReqDTO requestParam);

    /**
     * 恢复短链接
     * @param requestParam
     */
    void recoverRecoverBin(RecycleBinRecoverReqDTO requestParam);

    /**
     * 移除短链接
     * @param requestParam
     */
    void removeRecycleBin(RecycleBinRemoveReqDTO requestParam);
}
