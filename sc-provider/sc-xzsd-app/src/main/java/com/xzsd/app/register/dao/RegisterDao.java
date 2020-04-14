package com.xzsd.app.register.dao;

import com.xzsd.app.register.entity.RegisterInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterDao {
    /**
     * 统计用户账号数量
     *
     * @param registerInfo 用户信息
     * @return
     */
    int countUserAcct(RegisterInfo registerInfo);
    /**
     * 统计手机号
     * @param registerInfo 用户信息
     * @return
     */
    int countPhone(RegisterInfo registerInfo);


    /**
     * 新增用户到user表
     *
     * @param registerInfo 用户信息
     * @return
     */
    int addUser(RegisterInfo registerInfo);
    /**
     * 新增用户到Client表
     *
     * @param registerInfo 用户信息
     * @return
     */
    int addUserClient(RegisterInfo registerInfo);
}
