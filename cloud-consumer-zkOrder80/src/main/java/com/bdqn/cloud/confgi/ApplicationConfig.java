package com.bdqn.cloud.confgi;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/23 13:43
 * @company alibaba
 */
@Configuration
public class ApplicationConfig {

    @Bean
    @LoadBalanced     //默认的负载均衡轮训机制,是rebbian默认的.
    public RestTemplate getTestTemplate() {
        return new RestTemplate();
    }

}
