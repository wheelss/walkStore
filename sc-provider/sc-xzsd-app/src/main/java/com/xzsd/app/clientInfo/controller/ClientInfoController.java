package com.xzsd.app.clientInfo.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientInfo.entity.ClientInfo;
import com.xzsd.app.clientInfo.service.ClientInfoService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/clientInformation")
public class ClientInfoController {
    @Resource
    private ClientInfoService clientInfoService;
    public static final Logger logger = LoggerFactory.getLogger(ClientInfoController.class);
    /**
     * 修改客户店铺邀请码
     * @param clientInfo
     * @return
     * @author xiekai
     * @time 2020-4-15
     */
    @PostMapping("updateClientInvite")
    public AppResponse updateClientInvite(ClientInfo clientInfo){
        String userId = SecurityUtils.getCurrentUserId();
        clientInfo.setUserId(userId);
        try {
            return clientInfoService.updateClientInvite(clientInfo);
        }catch (Exception e){
            logger.error("修改邀请码失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
