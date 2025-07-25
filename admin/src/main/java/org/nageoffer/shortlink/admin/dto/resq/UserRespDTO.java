package org.nageoffer.shortlink.admin.dto.resq;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.nageoffer.shortlink.admin.common.serialize.PhoneDesensitizationSerializer;

/**
 * 用户响应数据传输对象
 */
@Data
public class UserRespDTO {
    /**
     * ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    @JsonSerialize(using = PhoneDesensitizationSerializer.class)
    private String phone;

    /**
     * 邮箱
     */
    private String mail;
}
