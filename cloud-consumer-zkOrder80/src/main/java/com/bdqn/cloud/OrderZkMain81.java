package com.bdqn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/23 13:37
 * @company alibaba
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain81 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain81.class, args);
    }
}
