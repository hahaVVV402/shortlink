package org.nageoffer.shortlink.admin.config;

import feign.RequestInterceptor;
import org.nageoffer.shortlink.admin.common.biz.user.UserContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * openFeign 微服务调用传递用户信息配置
 */
@Configuration
public class OpenFeignConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            template.header("username", UserContext.getUsername());
            template.header("userId", UserContext.getUserId());
            template.header("realName", UserContext.getRealName());
        };
    }
}
