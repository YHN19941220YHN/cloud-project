package com.bdqn.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/24 13:38
 * @company alibaba
 */
@Configuration
public class ApplicationContextConfig {
    /**
     * @Bean  将组件添加到容器中
     * @LoadBalanced 客户端负载均衡注解,负载均衡轮训机制,是ribbon默认的
     * @return
     */
    @Bean
    @LoadBalanced     //默认的负载均衡轮训机制,是rebbian默认的.
    public RestTemplate getTestTemplate() {
        return new RestTemplate();
    }




}
