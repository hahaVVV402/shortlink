package org.nageoffer.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.nageoffer.shortlink.admin.dao.entity.UserDO;
import org.nageoffer.shortlink.admin.dto.req.UserLoginReqDTO;
import org.nageoffer.shortlink.admin.dto.req.UserRegisterReqDTO;
import org.nageoffer.shortlink.admin.dto.req.UserUpdateReqDTO;
import org.nageoffer.shortlink.admin.dto.resq.UserLoginRespDTO;
import org.nageoffer.shortlink.admin.dto.resq.UserRespDTO;

/**
 * 用户接口层
 */

public interface UserService extends IService<UserDO> {
    /**
     * 根据用户名查询用户信息
     * @return 用户响应数据传输对象
     */
    UserRespDTO getUserByUsername(String username);

    /**
     * 查询用户名是否存在
     * @param username
     * @return
     */
    Boolean hasUsername(String username);

    /**
     * 注册用户
     * @param requestParam 用户注册请求数据传输对象
     */
    void registerUser(UserRegisterReqDTO requestParam);

    /**
     * 根据用户名修改用户信息
     * @param requestParam
     */
    void update(UserUpdateReqDTO requestParam);


    /**
     * 用户登录
     * @param requestParam 用户登录请求数据传输对象
     * @return 用户登录响应数据传输对象
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);
}
