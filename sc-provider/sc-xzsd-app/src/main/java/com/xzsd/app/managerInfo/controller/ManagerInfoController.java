package com.xzsd.app.managerInfo.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.managerInfo.service.ManagerInfoService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/manangerInformation")
public class ManagerInfoController {
    @Resource
    private ManagerInfoService managerInfoService;
    public static final Logger logger = LoggerFactory.getLogger(ManagerInfoController.class);

    /**
     * 查询店长门下司机信息
     * @return
     * @author xiekai
     * @time 2020-4-15
     */
    @PostMapping("listManangerDrivers")
    public AppResponse listManangerDrivers(){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return managerInfoService.listManangerDrivers(userId);
        }catch (Exception e){
            logger.error("查询司机信息列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
