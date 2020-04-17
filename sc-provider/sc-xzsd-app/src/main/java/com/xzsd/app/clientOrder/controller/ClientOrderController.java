package com.xzsd.app.clientOrder.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.clientOrder.service.ClientOrderService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/clientOrder")
public class ClientOrderController {
    @Resource
    private ClientOrderService clientOrderService;
    public static final Logger logger = LoggerFactory.getLogger(ClientOrderController.class);

    /**
     *新增订单
     * @param clientOrderInfo
     * @return
     * @author xiekai
     * @time 2020-4-16
     */
    @PostMapping("addOrder")
    public AppResponse addOrder(ClientOrderInfo clientOrderInfo){
        //获取当前登录人
        String userId = SecurityUtils.getCurrentUserId();
        clientOrderInfo.setUserId(userId);
        try {
            return clientOrderService.addOrder(clientOrderInfo);
        }catch (Exception e){
            logger.error("新增订单失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     *修改订单状态
     * @param clientOrderInfo
     * @return
     * @author xiekai
     * @time 2020-4-17
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(ClientOrderInfo clientOrderInfo){
        //获取登录id
        String userId = SecurityUtils.getCurrentUserId();
        clientOrderInfo.setUserId(userId);
        try {
            return clientOrderService.updateOrderState(clientOrderInfo);
        }catch (Exception e){
            logger.error("修改订单状态失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     *查询订单评价商品信息列表
     * @param orderId
     * @return
     * @author xiekai
     * @time 2020-4-17
     */
    @PostMapping("listGoodsForEvaluate")
    public AppResponse listGoodsForEvaluate(String orderId){
        try {
            return clientOrderService.listGoodsForEvaluate(orderId);
        }catch (Exception e){
            logger.error("查询订单评价列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
