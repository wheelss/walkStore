package com.xzsd.app.clientOrder.service;

import com.xzsd.app.clientOrder.dao.ClientOrderDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ClientOrderService {
    @Resource
    private ClientOrderDao clientOrderDao;
}
