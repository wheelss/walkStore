package com.xzsd.pc.driver.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.service.DriverService;
import com.xzsd.pc.good.controller.GoodController;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * 司机模块
 */
@RestController
@RequestMapping("/driver")
public class DriverController {
    @Resource
    private DriverService driverService;
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);
    /**
     * 新增司机
     * @param driverInfo
     * @return
     * @author xiekai
     * @time 2020-4-10
     */
    @PostMapping("addDriver")
    public AppResponse addDriver(DriverInfo driverInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        driverInfo.setCreateUser(userId);
        try {
            AppResponse appResponse = driverService.addDriver(driverInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("司机新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询司机详情
     * @param driverId
     * @return AppResponse
     * @author xiekai
     * @Date 2020-04-09
     */
    @RequestMapping(value = "getDriver")
    public AppResponse getDriver(String driverId) {
        try {
            return driverService.getDriver(driverId);
        } catch (Exception e) {
            logger.error("司机查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 司机列表(分页)
     * @param driverInfo
     * @return AppResponse
     * @author xiekai
     * @Date 2020-04-12
     */
    @RequestMapping(value = "listDrivers")
    public AppResponse listDrivers(DriverInfo driverInfo) {
        try {
            return driverService.listDrivers(driverInfo);
        } catch (Exception e) {
            logger.error("查询司机列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改司机
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-10
     */
    @PostMapping("updateDriver")
    public AppResponse updateDriver(DriverInfo driverInfo) {
        String userIds = SecurityUtils.getCurrentUserId();
        driverInfo.setUpdateUser(userIds);
        try {
            return driverService.updateDriver(driverInfo);
        } catch (Exception e) {
            logger.error("修改司机信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除司机
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-12
     */
    @PostMapping("deleteDriver")
    public AppResponse deleteDriver(String driverId) {
        String userId = SecurityUtils.getCurrentUserId();
        try {
            return driverService.deleteDriver(driverId, userId);
        } catch (Exception e) {
            logger.error("司机删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
