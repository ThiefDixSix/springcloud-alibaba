package com.cyc.springcloud.service;

import com.cyc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public int create(Payment payment); //写

    public Payment getPaymentById(@Param("id") Long id);  //读取
}
