package org.nageoffer.shortlink.admin.common.constant;

/**
 * Redis缓存常量类
 * <p>
 * 该类用于定义Redis缓存相关的常量。
 * </p>
 */
public class RedisCacheConstant {
    /**
     * 用户注册分布式锁
     */
    public static final String LOCK_USER_REGISTER_KEY = "short-link:lock_user-register:";

    /**
     * 分组创建分布式锁
     */
    public static final String LOCK_GROUP_CREATE_KEY = "short-link:lock_group-creat:%s";

    public static final String USER_LOGIN_KEY = "short-link:login:";

}
