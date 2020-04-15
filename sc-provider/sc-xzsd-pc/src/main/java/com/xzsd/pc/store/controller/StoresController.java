package com.xzsd.pc.store.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.entity.StoresInfo;
import com.xzsd.pc.store.service.StoresService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/store")
public class StoresController {
    @Resource
    private StoresService storesService;

    private static final Logger logger = LoggerFactory.getLogger(StoresController.class);

    /**
     * 新增门店
     *
     * @param storesInfo
     * @return
     * @author xiekai
     * @time 2020-4-10
     */
    @PostMapping("addStore")
    public AppResponse addStore(StoresInfo storesInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        storesInfo.setCreateUser(userId);
        try {
            AppResponse appResponse = storesService.addStore(storesInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("门店新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询门店详情
     *
     * @param storeId
     * @return AppResponse
     * @author xiekai
     * @Date 2020-04-09
     */
    @RequestMapping(value = "getStore")
    public AppResponse getStore(String storeId) {
        try {
            return storesService.getStore(storeId);
        } catch (Exception e) {
            logger.error("门店查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 门店列表(分页)
     *
     * @param storesInfo
     * @return AppResponse
     * @author xiekai
     * @Date 2020-04-09
     */
    @RequestMapping(value = "listStores")
    public AppResponse listStores(StoresInfo storesInfo) {
        try {
            return storesService.listStores(storesInfo);
        } catch (Exception e) {
            logger.error("查询门店列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改门店
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-10
     */
    @PostMapping("updateStore")
    public AppResponse updateStore(StoresInfo storesInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        storesInfo.setUpdateUser(userId);
        try {
            return storesService.updateStore(storesInfo);
        } catch (Exception e) {
            logger.error("修改门店信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除门店
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-9
     */
    @PostMapping("deleteStore")
    public AppResponse deleteStore(String storeId) {
        String userId = SecurityUtils.getCurrentUserId();
        try {
            return storesService.deleteStore(storeId, userId);
        } catch (Exception e) {
            logger.error("门店删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
