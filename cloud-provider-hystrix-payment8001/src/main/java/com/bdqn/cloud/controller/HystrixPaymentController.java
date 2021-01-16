package com.bdqn.cloud.controller;

import com.bdqn.cloud.service.HystrixPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/27 21:56
 * @company alibaba
 */
@RestController
@Slf4j
public class HystrixPaymentController {

    @Autowired
    private HystrixPaymentService hystrixPaymentService;


    @Value("${server.port}")
    private String serverPort;

    /**
     * 模拟正常访问
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_OK(@PathVariable("id") Integer id) {
        String result = hystrixPaymentService.PaymentInfo_OK(id);
        return result;
    }

    /**
     * 模拟服务调用超时或者服务器内部错误
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String PaymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String str = hystrixPaymentService.PaymentInfo_TimeOut(id);
        log.info("==========" + str);
        return str;
    }

    /**
     * 服务熔断
     * @param id
     * @return
     */
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = hystrixPaymentService.paymentCircuitBreaker(id);
        log.info("======result:" + result);
        return result;
    }
}
