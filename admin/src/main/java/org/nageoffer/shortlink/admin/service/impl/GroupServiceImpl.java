package org.nageoffer.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.nageoffer.shortlink.admin.dao.entity.GroupDO;
import org.nageoffer.shortlink.admin.dao.mapper.GroupMapper;
import org.nageoffer.shortlink.admin.service.GroupService;
import org.springframework.stereotype.Service;

/**
 * 分组接口层实现
 */
@Slf4j
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {

    // 这里可以添加具体的业务逻辑方法实现
}
