package com.cyc.springcloud.controller;

import com.cyc.springcloud.entities.CommonResult;
import com.cyc.springcloud.entities.Payment;
import com.cyc.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
    @GetMapping("consumer/payment/feign/timeout")
    public String timeOut(){
        return paymentFeignService.timeOut();
    }
}
