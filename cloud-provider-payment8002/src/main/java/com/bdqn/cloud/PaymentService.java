package com.bdqn.cloud;

import com.bdqn.cloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/17 20:33
 * @company alibaba
 */
public interface PaymentService {
    //添加
    int add(Payment payment);

    //查询
    Payment getPaymentById(@Param("id") Integer id);
}
