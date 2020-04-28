package com.xzsd.app.manangerOrder.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.manangerOrder.entity.ManagerOrderInfo;
import com.xzsd.app.manangerOrder.service.ManagerOrderService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/managerOrder")
public class ManagerOrderController {
    public static final Logger logger = LoggerFactory.getLogger(ManagerOrderController.class);
    @Resource
    private ManagerOrderService managerOrderService;

    /**
     * 修改店长订单状态
     * @param managerOrderInfo
     * @return
     * @author xiekai
     * @time 2020-4-17
     */
    @PostMapping("updateManangerOrderState")
    public AppResponse updateManangerOrderState(ManagerOrderInfo managerOrderInfo){
        //获取登录用户id
        String userId = SecurityUtils.getCurrentUserId();
        managerOrderInfo.setUserId(userId);
        try {
            return managerOrderService.updateManangerOrderState(managerOrderInfo);
        }catch (Exception e){
            logger.error("修改订单状态失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询订单列表
     * @param clientOrderInfo
     * @return
     * @author xiekai
     * @time 2020-4-21
     */
    @RequestMapping("listManagerOrders")
    public AppResponse listManagerOrders(ClientOrderInfo clientOrderInfo){
        String userId = SecurityUtils.getCurrentUserId();
        clientOrderInfo.setManagerId(userId);
        try{
            AppResponse appResponse = managerOrderService.listManagerOrders(clientOrderInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("查询订单列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单详情
     * @param orderId
     * @return
     * @author xiekai
     * @time 2020-4-21
     */
    @RequestMapping("listManagerOrderDeepen")
    public AppResponse listManagerOrderDeepen(String orderId){
        try{
            AppResponse appResponse = managerOrderService.listManagerOrderDeepen(orderId);
            return appResponse;
        }catch (Exception e){
            logger.error("查询订单详情失败");
            System.out.println(e.toString());
            throw e;
        }
    }

}
