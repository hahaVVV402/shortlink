package org.nageoffer.shortlink.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.nageoffer.shortlink.project.dao.entity.ShortLinkDO;
import org.nageoffer.shortlink.project.dto.req.RecycleBinSaveReqDTO;

/**
 * 回收站服务接口
 */
public interface RecycleBinService extends IService<ShortLinkDO> {
    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);
}
