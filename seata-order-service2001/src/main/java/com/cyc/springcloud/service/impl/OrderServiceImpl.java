package com.cyc.springcloud.service.impl;

import com.cyc.springcloud.dao.OrderDao;
import com.cyc.springcloud.domain.Order;
import com.cyc.springcloud.service.AccountService;
import com.cyc.springcloud.service.OrderService;
import com.cyc.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;
    @Override
    @GlobalTransactional(name = "create",rollbackFor = Exception.class)
    public void create(Order order) {

        log.info("----------开始新建订单");
        orderDao.create(order);
        log.info("----------开始做扣减库存操作，扣减ID{},扣减数量{}",order.getProductId(),order.getCount());
        storageService.decreate(order.getProductId(),order.getCount());
        log.info("----------开始做账户操作，用户id{},扣减金额{}",order.getUserId(),order.getMoney());
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----------修改订单状态");
        orderDao.update(order.getUserId(),0);

    }
}
