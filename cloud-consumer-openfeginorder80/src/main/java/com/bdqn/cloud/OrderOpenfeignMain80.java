package com.bdqn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/25 12:49
 * @company alibaba
 */
@SpringBootApplication
@EnableFeignClients       // 开启并激活openfegin,完成远程调用和客户端端负载均衡
public class OrderOpenfeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenfeignMain80.class, args);
    }
}
