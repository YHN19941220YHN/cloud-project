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
 * @date 2020/09/23 13:03
 * @company alibaba
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String payMentZk(){
        return "springcloud with zookeeper的端口:" + serverPort + "====>\t" + UUID.randomUUID().toString();
    }
}
