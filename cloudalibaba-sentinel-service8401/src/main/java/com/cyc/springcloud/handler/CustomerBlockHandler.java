package com.cyc.springcloud.handler;


import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cyc.springcloud.entities.CommonResult;
import com.cyc.springcloud.entities.Payment;

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException e){
        return new CommonResult(4444,"按客户自定义的global异常返回",new Payment(2020L,"Serial2020"));
    }

    public static CommonResult handlerException2(BlockException e){
        return new CommonResult(4444,"按客户自定义的global异常返回",new Payment(2020L,"Serial2020"));
    }
}
