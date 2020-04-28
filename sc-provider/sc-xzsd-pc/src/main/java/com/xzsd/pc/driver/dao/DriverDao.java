package com.xzsd.pc.driver.dao;

import com.xzsd.pc.driver.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 司机模块
 */
@Mapper
public interface DriverDao {
    /**
     * 新增司机到司机表
     *
     * @param driverInfo 司机信息
     * @return
     */
    int addDriver(DriverInfo driverInfo) ;
    /**
     * 统计用户账号数量
     *
     * @param driverInfo 用户信息
     * @return
     */
    int countUserAcct(DriverInfo driverInfo);
    /**
     * 新增司机到用户表
     *
     * @param driverInfo 司机信息
     * @return
     */
    int addDriverUser(DriverInfo driverInfo) ;
    /**
     * 查询司机信息
     *
     * @param driverId 司机id
     * @return 修改结果
     */
    DriverInfo getDriver(@Param("driverId") String driverId);
    /**
     * 获取所有司机信息
     *
     * @param driverInfo 司机信息
     * @return 所有司机信息
     */
    List<DriverInfo> listDrivers(DriverInfo driverInfo) ;
    /**
     * 获取当前登录司机信息
     *
     * @param driverInfo 司机信息
     * @return 所有当前登录司机信息
     */
    List<DriverInfo> listDriver(DriverInfo driverInfo);
    /**
     * 修改司机表司机信息
     *
     * @param driverInfo 司机信息
     * @return 修改结果
     */
    int updateDriver(DriverInfo driverInfo);
    /**
     * 修改用户表司机信息
     *
     * @param driverInfo 司机信息
     * @return 修改结果
     */
    int updateDriverUser(DriverInfo driverInfo);
    /**
     * 删除司机信息
     *
     * @param listCode 选中的司机编号集合
     * @return
     */
    int deleteDriver(@Param("listCode") List<String> listCode, @Param("updateUser") String updateUser);
    /**
     * 删除司机信息
     *
     * @param listCode 选中的司机编号集合
     * @return
     */
    int deleteDriverUser(@Param("listCode") List<String> listCode, @Param("updateUser") String updateUser);
    /**
     * 获取当前登录用户的密码
     *
     * @param driverId
     * @return
     */
    String getUserPassword(@Param("driverId") String driverId);
}

