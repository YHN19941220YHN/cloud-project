package com.bdqn.cloud.controller;


import com.bdqn.cloud.pojo.CommonResult;
import com.bdqn.cloud.pojo.Payment;
import com.bdqn.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/17 20:43
 * @company alibaba
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 添加
     * @param payment
     * @return
     */
    @PostMapping("/payment/add")
    public CommonResult create(Payment payment) {
        int result = paymentService.add(payment);
        log.info("==============" + result);
        if (result > 0) {
            return new CommonResult(200,"插入成功.端口号==========>" + serverPort,result);
        } else {
            return new CommonResult(444, "插入失败",null);
        }
    }


    /**
     * 查询,根据id
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("==============" + payment);
        if (payment != null) {
            return new CommonResult(200,"查询成功,端口号==========>" + serverPort,payment);
        } else {
            return new CommonResult(444, "没有查询的数据,查询ID:" + id,null);
        }
    }


    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("========element" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    /**
     * Gateway 网关路由
     * @return
     */
    @GetMapping("/payment/lb")
    public String getPaymentLb() {
        return serverPort;
    }
}
