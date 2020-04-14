package com.xzsd.app.userInformation.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.user.controller.UserController;
import com.xzsd.app.userInformation.entity.UserInformationInfo;
import com.xzsd.app.userInformation.service.UserInformationService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userInformation")
public class UserInformationController {
    @Resource
    private UserInformationService userInformationService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 查询用户详情
     * @return AppResponse
     * @author xiekai
     * @time 2020-04-14
     */
    @RequestMapping(value = "getUser")
    public AppResponse getUser() {
        String userId = SecurityUtils.getCurrentUserId();
        try {
            return userInformationService.getUser(userId);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改密码
     * @param userInformationInfo
     * @return
     * @author xiekai
     * @time 2020-04-14
     */
    @PostMapping("updateUserPassword")
    public AppResponse updateUserPassword(UserInformationInfo userInformationInfo){
        String userId = SecurityUtils.getCurrentUserId();
        userInformationInfo.setUserId(userId);
        try {
            return userInformationService.updateUserPassword(userInformationInfo);
        }catch (Exception e){
            logger.error("修改密码失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
