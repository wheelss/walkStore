package com.xzsd.app.register.service;

import com.xzsd.app.register.dao.RegisterDao;
import com.xzsd.app.register.entity.RegisterInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.PasswordUtils;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class RegisterService {
    @Resource
    private RegisterDao registerDao;
    /**
     * 新增用户
     *
     * @param registerInfo
     * @return
     * @author xiekai
     * @time 2020-4-14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse clientRegister(RegisterInfo registerInfo) {
        registerInfo.setUserId(StringUtil.getCommonCode(2));
        //检验客户账号
        int countUserAcct = registerDao.countUserAcct(registerInfo);
        if (0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        //检验手机号码
        int countPhone = registerDao.countPhone(registerInfo);
        if (0 != countPhone) {
            return AppResponse.bizError("手机号已被注册，请重新输入！");
        }
        //检验是否有此店铺邀请码
        if(registerInfo.getInviteCode() != null){
            int countInviteCode = registerDao.countInviteCode(registerInfo);
            if (0 != countInviteCode) {
                return AppResponse.bizError("无此店铺邀请码");
            }
        }
        //密码加密
        String pwd = PasswordUtils.generatePassword(registerInfo.getUserPassword());
        registerInfo.setUserPassword(pwd);
        // 新增用户到user
        int count = registerDao.addUser(registerInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        //新增用户到客户表
        int counts = registerDao.addUserClient(registerInfo);
        if (0 == counts) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
}
