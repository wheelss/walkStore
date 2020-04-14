package com.xzsd.app.register.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.register.entity.RegisterInfo;
import com.xzsd.app.register.service.RegisterService;
import com.xzsd.app.user.controller.UserController;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Resource
    private RegisterService registerService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 新增用户
     *
     * @param registerInfo
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-14
     */
    @PostMapping("clientRegister")
    public AppResponse clientRegister(RegisterInfo registerInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        registerInfo.setCreateUser(userId);
        try {
            AppResponse appResponse = registerService.clientRegister(registerInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
