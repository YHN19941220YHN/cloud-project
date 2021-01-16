package com.bdqn.cloud.controller;

import com.bdqn.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/27 22:58
 * @company alibaba
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallBackMethod")
public class HystrixController {

    @Autowired
    private PaymentService paymentService;

    /**
     * 正常方法请求
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentInfo_OK(id);
        return result;
    }

    /**
     * 模拟调用超时或者方法抛出异常
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "5000")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int i =  10 / 0;
        String str = paymentService.paymentInfo_TimeOut(id);
        return str;
    }

    /**
     * 上面方法出错后的兜底数据
     * @return
     */
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "消费者80,对方支付系统繁忙或者调用出错========";
    }

    // 全局fallback
    public String payment_Global_FallBackMethod() {
        return "Global异常处理信息,请稍后重试";
    }
}
