package org.nageoffer.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.nageoffer.shortlink.admin.dao.entity.UserDO;
import org.nageoffer.shortlink.admin.dto.resq.UserRespDTO;

/**
 * 用户接口层
 */

public interface UserService extends IService<UserDO> {
    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户响应数据传输对象
     */
    UserRespDTO getUserByUsername(String username);
}
