package com.bdqn.cloud;

import com.bdqn.cloud.pojo.CommonResult;
import com.bdqn.cloud.pojo.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/25 13:06
 * @company alibaba
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OpenFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Integer id) ;

   /* @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();*/
}
