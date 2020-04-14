package com.xzsd.app.userInformation.service;

import com.xzsd.app.userInformation.dao.UserInformationDao;
import com.xzsd.app.userInformation.entity.UserInformationInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserInformationService {
    @Resource
    private UserInformationDao userInformationDao;
    /**
     * 查询用户详情
     * @return
     * @Author xiekai
     * @time 2020-04-14
     */
    public AppResponse getUser(String UserId){
        int role = userInformationDao.getRole(UserId);
        UserInformationInfo userInformationInfo = null;
        if(role == 2){
            //店长
            userInformationInfo = userInformationDao.getStore(UserId);
            userInformationInfo.setAddress(userInformationInfo.getProvinceName() + userInformationInfo.getCityName() + userInformationInfo.getAreaName() + userInformationInfo.getAddress());
        }else if(role == 3){
            //司机
            userInformationInfo = userInformationDao.getDriver(UserId);
        }else if(role == 4){
            //客户
            userInformationInfo = userInformationDao.getCustomer(UserId);
        }
        if(userInformationInfo == null){
            return AppResponse.bizError("查询用户个人信息失败！");
        }
        return AppResponse.success("查询用户个人信息成功", userInformationInfo);
    }

    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUserPassword(UserInformationInfo userInformationInfo){
        //获取密码
        String userPassword = userInformationDao.getUserPassword(userInformationInfo.getUserId());
        //判断密码是否相同
        boolean bool = PasswordUtils.equalPassword(userInformationInfo.getUserPassword(), userPassword);
        if(!bool){
            return AppResponse.bizError("原密码不正确，请重新输入");
        }
        //密码加密
        String userNewPassword = userInformationInfo.getUserNewPassword();
        String pwd = PasswordUtils.generatePassword(userNewPassword);
        userInformationInfo.setUserNewPassword(pwd);
        int count = userInformationDao.updateUserPassword(userInformationInfo);
        if(0 == count){
            return AppResponse.bizError("修改密码失败");
        }
        return AppResponse.success("修改密码成功");
    }
}
