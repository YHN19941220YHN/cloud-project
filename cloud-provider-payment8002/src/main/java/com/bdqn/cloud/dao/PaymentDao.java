package com.bdqn.cloud.dao;

import com.bdqn.cloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/17 13:50
 * @company alibaba
 */

@Mapper
//@Repository
public interface PaymentDao {
    //添加
    int add(Payment payment);

    //查询
    Payment getPaymentById(@Param("id") Integer id);
}
