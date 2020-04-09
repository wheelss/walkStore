package com.xzsd.pc.order.service;

import com.xzsd.pc.order.dao.OrderDeepenDao;
import com.xzsd.pc.order.entity.OrderDeepenInfo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderDeepenService {
    @Resource
    private OrderDeepenDao orderDeepenDao;

    /**
     * 查询订单详情
     * @param orderId
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    public AppResponse getListOrder(String orderId) {
        OrderDeepenInfo orderDeepenInfo = orderDeepenDao.getListOrder(orderId);
        return AppResponse.success("查询成功！", orderDeepenInfo);
    }

}
