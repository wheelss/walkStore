package com.xzsd.pc.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 用户
 *
 * @author xiekai
 * @time 2020-3-25
 */
@Service
public class UserService {
    @Resource
    private UserDao userDao;

    /**
     * 新增用户
     *
     * @param userInfo
     * @return
     * @author xiekai
     * @time 2020-3-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(UserInfo userInfo) {
        userInfo.setUserId(StringUtil.getCommonCode(2));
        int countUserAcct = userDao.countUserAcct(userInfo);
        if (0 != countUserAcct) {
            return AppResponse.versionError("用户账号已存在，请重新输入！");
        }
        //密码加密
        String pwd = PasswordUtils.generatePassword(userInfo.getUserPassword());
        userInfo.setUserPassword(pwd);
        // 新增用户
        int count = userDao.addUser(userInfo);
        if (0 == count) {
            return AppResponse.versionError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     * @Author xiekai
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userId,String updateUser) {
        List<String> listCode = Arrays.asList(userId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = userDao.deleteUser(listCode,updateUser);
        if (0 == count) {
            appResponse = AppResponse.notFound("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 修改用户
     *
     * @param userInfo
     * @return
     * @Author xiekai
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(UserInfo userInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        int countUserAcct = userDao.countUserAcct(userInfo);
        if (0 != countUserAcct) {
            return AppResponse.versionError("用户账号已存在，请重新输入！");
        }
        //密码加密
        String pwd = PasswordUtils.generatePassword(userInfo.getUserPassword());
        userInfo.setUserPassword(pwd);
        // 修改用户信息
        int count = userDao.updateUser(userInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 查询用户详情
     *
     * @param userId
     * @return
     * @Author xiekai
     * @Date 2020-03-25
     */
    public AppResponse getUser(String userId) {
        UserInfo userInfo = userDao.getUser(userId);
        return AppResponse.success("查询成功！", userInfo);
    }

    /**
     * demo 查询用户列表（分页）
     *
     * @param userInfo
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    public AppResponse listUsersPage(UserInfo userInfo) {
        PageHelper.startPage(userInfo.getPageNum(), userInfo.getPageSize());
        List<UserInfo> userInfoList = userDao.listUsersPage(userInfo);
        // 包装Page对象
        PageInfo<UserInfo> pageData = new PageInfo<UserInfo>(userInfoList);
        return AppResponse.success("查询成功！", pageData);
    }

}
