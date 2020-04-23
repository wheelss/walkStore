package com.xzsd.pc.client.controller;


import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.client.entity.ClientInfo;
import com.xzsd.pc.client.service.ClientService;
import com.xzsd.pc.user.controller.UserController;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * 查询客户
 */
@RestController
@RequestMapping("/client")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
    @Resource
    ClientService clientService;
    /**
     * 客户列表(分页)
     * @param clientInfo
     * @return AppResponse
     * @author xiekai
     * @Date 2020-4-8
     */
    @RequestMapping(value = "listClients")
    public AppResponse listClient(ClientInfo clientInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        clientInfo.setNowUserId(userId);
        try {
            return clientService.listClient(clientInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
