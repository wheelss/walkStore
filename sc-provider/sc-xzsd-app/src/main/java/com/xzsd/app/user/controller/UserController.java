package com.xzsd.app.user.controller;


import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.service.UserService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户管理增删改查
 *
 * @author xiekai
 * @time 2020-3-25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * 新增用户
     *
     * @param userInfo
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-25
     */
    @PostMapping("addUser")
    public AppResponse addUser(UserInfo userInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        userInfo.setCreateUser(userId);
        try {
            AppResponse appResponse = userService.addUser(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除用户
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-25
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(String userId) {
        String userIds = SecurityUtils.getCurrentUserId();
        try {
            return userService.deleteUser(userId,userIds);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改用户
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-25
     */
    @PostMapping("updateUser")
    public AppResponse updateUser(UserInfo userInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        userInfo.setUpdateUser(userId);
        try {
            return userService.updateUser(userInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询用户详情
     *
     * @param userId
     * @return AppResponse
     * @author xiekai
     * @Date 2020-03-25
     */
    @RequestMapping(value = "getUser")
    public AppResponse getUser(String userId) {
        try {
            return userService.getUser(userId);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 用户列表(分页)
     * @param userInfo
     * @return AppResponse
     * @author xiekai
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listUsers")
    public AppResponse listUsersPage(UserInfo userInfo) {
        try {
            return userService.listUsersPage(userInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
