package com.bdqn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import spring.cloud.ribbon.MyRibbon;

/**
 * 服务消费者
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/19 3:13
 * @company alibaba
 *
 *
 * @RibbonClient 将ribbon默认的负载均衡默认的轮询修改为随机,指定那个客户端要是用
 *               随机负载均衡机制,将自定义的配置类引入,注意:这个配置类不能放在
 *               @springbootapplication 注解的包扫描下面
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRibbon.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
