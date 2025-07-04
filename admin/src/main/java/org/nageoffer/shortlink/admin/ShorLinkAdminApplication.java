package org.nageoffer.shortlink.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.nageoffer.shortlink.admin.dao.mapper")
public class ShorLinkAdminApplication {
    public static void main(String[] args) {

        SpringApplication.run(ShorLinkAdminApplication.class, args);
    }
}
