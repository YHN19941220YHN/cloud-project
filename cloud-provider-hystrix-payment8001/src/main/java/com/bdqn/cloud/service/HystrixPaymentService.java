package com.bdqn.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.omg.CORBA.INTERNAL;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/27 21:48
 * @company alibaba
 */
@Service
public class HystrixPaymentService {

    /**
     * 正常访问方法Ok的
     * @param id
     * @return
     */
    public String PaymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "PaymentInfo_OK , id" + id + "\t" + "哈哈哈";
    }

    /**
     * 模拟超市和方法抛出异常的场景
     * @param id
     * @HystrixCommand 超市抛出兜底的方案
     * @HystrixProperty  value = "3000"表示3秒内是正常范围内的业务(这里设置了5秒)
     * @return
     *
     */
    @HystrixCommand(fallbackMethod = "payment_timeoutHandler", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "4000")
    })
    public String PaymentInfo_TimeOut(Integer id) {
        //int age = 10 / 0 ; 服务出错
        // 服务超时
        try {
             TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池=========="+Thread.currentThread().getName()+" =======id:  "+id+"\t"+"O(∩_∩)O哈哈~"+"  耗时(秒): ";
    }

    /**
     * 服务降级的解决方案: 方法有异常后报出的兜底数据
     * @param id
     * @return
     */
    public String payment_timeoutHandler(Integer id) {
        return "线程池==========>" + Thread.currentThread().getName() + "<=======系统忙,请稍后重试!!, id:" + id + "\t" + "=======>";

    }

    //=============================服务熔断=================================

    /**
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),                      // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),         // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),   // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),       // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("-------id 不能为负数");
        }
        String str = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "===========调用成功,流水号是: " + str;
    }

    /**
     * 兜底方法
     * @param id
     * @return
     */
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能为负数,请稍后重试! id = " + id;
    }

}
