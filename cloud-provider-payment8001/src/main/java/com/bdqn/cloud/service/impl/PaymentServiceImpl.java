package com.bdqn.cloud.service.impl;
import com.bdqn.cloud.dao.PaymentDao;
import com.bdqn.cloud.pojo.Payment;
import com.bdqn.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/09/17 20:33
 * @company alibaba
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentDao.getPaymentById(id);
    }
}
