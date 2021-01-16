package com.bdqn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * zookeeper注册中心的启动类
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/23 13:01
 * @company alibaba
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
