package com.xzsd.pc.order.controller;


import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goodSort.controller.GoodSortController;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.service.OrderService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    /**
     * demo 订单列表(分页)
     * @param orderInfo
     * @return AppResponse
     * @author xiekai
     * @Date 2020-04-08
     */
    @RequestMapping(value = "listOrderPage")
    public AppResponse listOrderPage(OrderInfo orderInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        orderInfo.setNowUserId(userId);
        try {
            return orderService.listOrderPage(orderInfo);
        } catch (Exception e) {
            logger.error("查询订单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-8
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(OrderInfo orderInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        orderInfo.setUpdateUser(userId);
        try {
            return orderService.updateOrderState(orderInfo);
        } catch (Exception e) {
            logger.error("修改订单状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单详情
     *
     * @param orderId
     * @return AppResponse
     * @author xiekai
     * @Date 2020-03-25
     */
    @RequestMapping(value = "getListOrder")
    public AppResponse getListOrder(String orderId) {
        try {
            return orderService.getListOrder(orderId);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
