package com.cyc.springcloud.service.impl;

import com.cyc.springcloud.entities.CommonResult;
import com.cyc.springcloud.entities.Payment;
import com.cyc.springcloud.service.PaymentService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService
{
    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }

}
