package com.cyc.springcloud.service.impl;

import com.cyc.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)// 定义消息的推送管道
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {
    @Autowired
    @Qualifier("output")
    private MessageChannel outPut;//消息发送管道
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        outPut.send(MessageBuilder.withPayload(serial).build());
       log.info("serial is{}"+serial);
        return null;
    }
}
