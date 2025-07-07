package org.nageoffer.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.nageoffer.shortlink.admin.dao.entity.GroupDO;
import org.nageoffer.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import org.nageoffer.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import org.nageoffer.shortlink.admin.dto.resq.ShortLinkGroupRespDTO;

import java.util.List;

/**
 * 分组接口层
 */
public interface GroupService extends IService<GroupDO> {

    /**
     * 新增短链接分组
     * @param groupName
     */
    void saveGroup(String groupName);

    /**
     * 新增短链接分组
     * @param userName
     * @param groupName
     */
    void saveGroup(String userName, String groupName);

    List<ShortLinkGroupRespDTO> listGroup();

    /**
     * 更新分组
     */
    void updateGroup(ShortLinkGroupUpdateReqDTO requestParam);

    /**
     * 删除分组
     *
     * @param gid 分组 ID
     */
    void deleteGroup(String gid);

    /**
     * 对分组进行排序
     * @param requestParam
     */
    void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam);
}
