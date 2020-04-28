package com.xzsd.app.driverHome.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driverHome.entity.DriverHomeInfo;
import com.xzsd.app.driverHome.service.DriverHomeService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/driverHome")
public class DriverHomeController {
    @Resource
    private DriverHomeService driverHomeService;
    public static final Logger logger = LoggerFactory.getLogger(DriverHomeController.class);

    /**
     * 查询司机负责门店
     * @param driverHomeInfo
     * @return
     * @author xiekai
     * @time 2020-4-15
     */
    @PostMapping("listDriverStores")
    public AppResponse listDriverStores(DriverHomeInfo driverHomeInfo){
        String userId = SecurityUtils.getCurrentUserId();
        driverHomeInfo.setUserId(userId);
        try {
            return driverHomeService.listDriverStores(driverHomeInfo);
        }catch (Exception e){
            logger.error("查询司机负责门店失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
