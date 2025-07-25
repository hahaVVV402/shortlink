package org.nageoffer.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.nageoffer.shortlink.admin.common.convention.result.Result;
import org.nageoffer.shortlink.admin.common.convention.result.Results;
import org.nageoffer.shortlink.admin.dto.req.UserLoginReqDTO;
import org.nageoffer.shortlink.admin.dto.req.UserRegisterReqDTO;
import org.nageoffer.shortlink.admin.dto.req.UserUpdateReqDTO;
import org.nageoffer.shortlink.admin.dto.resq.UserActualRespDTO;
import org.nageoffer.shortlink.admin.dto.resq.UserLoginRespDTO;
import org.nageoffer.shortlink.admin.dto.resq.UserRespDTO;
import org.nageoffer.shortlink.admin.service.UserService;
import org.springframework.web.bind.annotation.*;

/*
用户管理控制层
*/

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 根据用户名获取用户信息
     */
    @GetMapping("/api/short-link/admin/v1/user/{username}")
    public Result<UserRespDTO> getUserByUsername(@PathVariable("username") String username) {

        UserRespDTO result = userService.getUserByUsername(username);
        return Results.success(result);


    }

    /**
     * 根据用户名获取无脱敏用户信息
     * @return
     */
    @GetMapping("/api/short-link/admin/v1/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByUsername(@PathVariable("username") String username) {

        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualRespDTO.class));


    }

    @GetMapping("/api/short-link/admin/v1/user/has-username")
    public Result<Boolean> hasUsername(@RequestParam("username") String username) {
        return Results.success(userService.hasUsername(username));
    }

    /**
     * 注册用户
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/admin/v1/user")
    public Result<Void> register(@RequestBody UserRegisterReqDTO requestParam) {
        userService.register(requestParam);
        return Results.success();
    }

    /**
     * 根据用户名修改用户信息
     * @param requestParam
     * @return
     */
    @PutMapping("/api/short-link/admin/v1/user")
    public Result<Void> update(@RequestBody UserUpdateReqDTO requestParam) {
        userService.update(requestParam);
        return Results.success();
    }

    /**
     * 用户登录
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/admin/v1/user/login")
    public Result<UserLoginRespDTO> login(@RequestBody UserLoginReqDTO requestParam) {
        UserLoginRespDTO result =userService.login(requestParam);
        return Results.success(result);
    }

    /**
     * 检查用户是否登录
     * @param token 用户登录 Token
     * @return 是否登录
     */
    @GetMapping("/api/short-link/admin/v1/user/check-login")
    public Result<Boolean> checkLogin(@RequestParam("username") String username,@RequestParam("token") String token) {
        return Results.success(userService.checkLogin(username,token));
    }

    /**
     * 退出登录
     * @param username
     * @param token
     * @return
     */
    @DeleteMapping("/api/short-link/admin/v1/user/logout")
    public Result<Void> logout(@RequestParam("username") String username, @RequestParam("token") String token) {
        userService.logout(username, token);
        return Results.success();
    }
}
