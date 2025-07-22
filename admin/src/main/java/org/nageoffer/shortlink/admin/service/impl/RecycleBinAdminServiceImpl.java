package org.nageoffer.shortlink.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.nageoffer.shortlink.admin.common.biz.user.UserContext;
import org.nageoffer.shortlink.admin.common.convention.exception.ServiceException;
import org.nageoffer.shortlink.admin.common.convention.result.Result;
import org.nageoffer.shortlink.admin.dao.entity.GroupDO;
import org.nageoffer.shortlink.admin.dao.mapper.GroupMapper;
import org.nageoffer.shortlink.admin.remote.ShortLinkActualRemoteService;
import org.nageoffer.shortlink.admin.remote.dto.req.ShortLinkRecyclePageReqDTO;
import org.nageoffer.shortlink.admin.remote.dto.resq.ShortLinkPageRespDTO;
import org.nageoffer.shortlink.admin.service.RecycleBinService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * URL回收站实现层
 */
@Service(value = "recycleBinServiceByAdmin")
@RequiredArgsConstructor
public class RecycleBinAdminServiceImpl implements RecycleBinService {
    private final ShortLinkActualRemoteService shortLinkActualRemoteService;
    private final GroupMapper groupMapper;


    @Override
    public Result<Page<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecyclePageReqDTO requestParam) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getDelFlag, 0);
        List<GroupDO> groupDOList = groupMapper.selectList(queryWrapper);
        if (CollUtil.isEmpty(groupDOList)){
            throw new ServiceException("用户无分组信息");
        }
        requestParam.setGidList(groupDOList.stream().map(GroupDO::getGid).toList());
        return shortLinkActualRemoteService.pageRecycleBinShortLink(
                requestParam.getGidList(),
                requestParam.getCurrent(),
                requestParam.getSize());
    }
}
