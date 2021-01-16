package com.bdqn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/27 22:55
 * @company alibaba
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderMain80.class, args);
    }
}
