package com.bdqn.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/28 13:48
 * @company alibaba
 */
@Component
public class PaymentServiceImpl implements PaymentService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-------PaymentServiceImpl ------paymentInfo_OK===>服务器宕机";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------PaymentServiceImpl----paymentInfo_TimeOut";
    }
}
