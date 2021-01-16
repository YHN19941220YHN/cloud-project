package com.bdqn.cloud.controller;

import com.bdqn.cloud.pojo.CommonResult;
import com.bdqn.cloud.pojo.Payment;
import com.bdqn.cloud.OpenFeignService;
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
 * @date 2020/09/25 13:05
 * @company alibaba
 */
@RestController
@Slf4j
public class OpenfeignController {

    @Autowired
    private OpenFeignService openFeignService;

    /**
     *
     * @param id
     * @PathVariable 从路径中取变量的值
     * @return
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id) {
        return openFeignService.getPaymentById(id);
    }

 /*   @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut() {
        // OpenFeign客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }


    @Configuration
public class OpenFeignService {

    @Bean
    Logger.Level loggerLevel() {
        return Logger.Level.FULL;
    }
}








    */

}
