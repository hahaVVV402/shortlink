package org.nageoffer.shortlink.aggregation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 短链接聚合应用
 */
@SpringBootApplication(scanBasePackages = {
        "org.nageoffer.shortlink.project",
        "org.nageoffer.shortlink.admin"
})
@EnableDiscoveryClient
@MapperScan(value = {
        "org.nageoffer.shortlink.project.dao.mapper",
        "org.nageoffer.shortlink.admin.dao.mapper",
})
public class AggregationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AggregationServiceApplication.class, args);
    }
}