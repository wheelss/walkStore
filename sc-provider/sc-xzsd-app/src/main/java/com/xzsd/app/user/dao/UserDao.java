package com.xzsd.app.user.dao;

import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户
 *
 * @author
 * @time 2020-3-25
 */
@Mapper
public interface UserDao {
    /**
     * 统计用户账号数量
     *
     * @param userInfo 用户信息
     * @return
     */
    int countUserAcct(UserInfo userInfo);

    /**
     * 新增用户
     *
     * @param userInfo 用户信息
     * @return
     */
    int addUser(UserInfo userInfo);

    /**
     * 删除用户信息
     *
     * @param listCode 选中的用户编号集合
     * @return
     */
    int deleteUser(@Param("listCode") List<String> listCode, @Param("updateUser") String updateUser);

    /**
     * 修改用户信息
     *
     * @param userInfo 用户信息
     * @return 修改结果
     */
    int updateUser(UserInfo userInfo);

    /**
     * 查询用户信息
     *
     * @param userId 用户编号
     * @return 修改结果
     */
    UserInfo getUser(@Param("userId") String userId);

    /**
     * 获取所有用户信息
     *
     * @param userInfo 用户信息
     * @return 所有用户信息
     */
    List<UserInfo> listUsersPage(UserInfo userInfo);
}
