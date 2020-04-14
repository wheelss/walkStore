package com.xzsd.app.userInformation.dao;

import com.xzsd.app.userInformation.entity.UserInformationInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;

@Mapper
public interface UserInformationDao {
    /**
     * 查询登录用户角色
     * @param userId
     * @return
     */
    int getRole(@Param("userId") String userId);

    /**
     * 查询店长个人信息
     *
     * @param userId
     * @return
     */
    UserInformationInfo getStore(@Param("userId") String userId);

    /**
     * 查询司机个人信息
     *
     * @param userId
     * @return
     */
    UserInformationInfo getDriver(@Param("userId") String userId);

    /**
     * 查询客户个人信息
     *
     * @param userId
     * @return
     */
    UserInformationInfo getCustomer(@Param("userId") String userId);
    /**
     * 获取当前登录用户的密码
     *
     * @param userId
     * @return
     */
    String getUserPassword(@Param("userId") String userId);
    /**
     * 修改用户密码
     *
     * @param userInformationInfo
     * @return
     */
    int updateUserPassword(UserInformationInfo userInformationInfo);


}
