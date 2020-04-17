package com.xzsd.app.manangerOrder.controller;

import com.neusoft.security.client.utils.SecurityUtils;
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
@RequestMapping("/manangerOrder")
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

}
