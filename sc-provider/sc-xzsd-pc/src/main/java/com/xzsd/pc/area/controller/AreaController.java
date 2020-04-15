package com.xzsd.pc.area.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.area.entity.AreaInfo;
import com.xzsd.pc.area.service.AreaService;
import com.xzsd.pc.user.controller.UserController;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/selectCombox")
public class AreaController {
    @Resource
    private AreaService areaService;
    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);

    /**
     * 省市区列表
     * @param areaInfo
     * @return AppResponse
     * @author xiekai
     * @Date 2020-4-13
     */
    @RequestMapping(value = "listArea")
    public AppResponse listArea(AreaInfo areaInfo) {
        try {
            return areaService.listArea(areaInfo);
        } catch (Exception e) {
            logger.error("查询省市区列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
