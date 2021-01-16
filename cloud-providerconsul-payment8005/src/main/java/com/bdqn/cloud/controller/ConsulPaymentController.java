package com.bdqn.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/24 13:13
 * @company alibaba
 */
@RestController
@Slf4j
public class ConsulPaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul() {
        return "springcloud with consul: "+serverPort+"\t"+ UUID.randomUUID().toString()+"\t:将服务提供者注册到consul中";
    }
}
