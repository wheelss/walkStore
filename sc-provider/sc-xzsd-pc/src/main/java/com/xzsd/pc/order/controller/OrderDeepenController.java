package com.xzsd.pc.order.controller;

import com.xzsd.pc.goodSort.controller.GoodSortController;
import com.xzsd.pc.order.service.OrderDeepenService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderDeepenController {
    @Resource
    private OrderDeepenService orderDeepenService;
    private static final Logger logger = LoggerFactory.getLogger(GoodSortController.class);


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
            return orderDeepenService.getListOrder(orderId);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
