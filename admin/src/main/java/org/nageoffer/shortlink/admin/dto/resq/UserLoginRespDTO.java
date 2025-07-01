package org.nageoffer.shortlink.admin.dto.resq;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** * 用户登录返回参数数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRespDTO {
    /**
     * 用户登录返回参数 Token
     */
    private String token;
}
