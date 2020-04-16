package com.xzsd.pc.driver.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class DriverService {
    @Resource
    private DriverDao driverDao;
    /**
     * 新增司机
     *
     * @param driverInfo
     * @return
     * @author xiekai
     * @time 2020-4-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver(DriverInfo driverInfo) {
        driverInfo.setDriverId(StringUtil.getCommonCode(2));
        //检验司机是否存在
        int countDriver = driverDao.countDriver(driverInfo);
        if (0 != countDriver) {
            return AppResponse.bizError("司机已存在，请重新输入！");
        }
        // 新增司机到司机表
        int count = driverDao.addDriver(driverInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        //新增司机到用户表
        int counts = driverDao.addDriverUser(driverInfo);
        if (0 == counts) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
    /**
     * 查询司机详情
     *
     * @param driverId
     * @return
     * @Author xiekai
     * @Date 2020-4-10
     */
    public AppResponse getDriver(String driverId)  {
        DriverInfo driverInfo = driverDao.getDriver(driverId);
        return AppResponse.success("查询成功！", driverInfo);
    }

    /**
     * demo 查询司机列表（分页）
     *
     * @param driverInfo
     * @return
     * @Author xiekai
     * @Date 2020-04-12
     */
    public AppResponse listDrivers(DriverInfo driverInfo)  {
        if ((driverInfo.getRole() == 0) ||(driverInfo.getRole() == 1)){
            //角色是管理员或者超级管理员
            PageHelper.startPage(driverInfo.getPageNum(), driverInfo.getPageSize());
            List<DriverInfo> goodInfoList = driverDao.listDrivers(driverInfo);
            PageInfo<DriverInfo> pageData = new PageInfo<DriverInfo>(goodInfoList);
            return AppResponse.success("查询成功！", pageData);
        }else{
            //角色是司机
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setDriverId(userId);
            PageHelper.startPage(driverInfo.getPageNum(), driverInfo.getPageSize());
            List<DriverInfo> goodInfoList = driverDao.listDriver(driverInfo);
            PageInfo<DriverInfo> pageData = new PageInfo<DriverInfo>(goodInfoList);
            return AppResponse.success("查询成功！", pageData);
        }
    }
    /**
     * demo 修改司机
     *
     * @param driverInfo
     * @return
     * @Author xiekai
     * @Date 2020-04-12
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver(DriverInfo driverInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验司机是否存在
        int countDriver = driverDao.countDriver(driverInfo);
        if (0 == countDriver) {
            return AppResponse.bizError("司机不存在");
        }
        // 修改司机表信息
        int count = driverDao.updateDriver(driverInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        //修改user表
        int counts = driverDao.updateDriverUser(driverInfo);
        if (0 == counts) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }
    /**
     * 删除司机
     *
     * @param driverId
     * @return
     * @Author xiekai
     * @Date 2020-04-09
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriver(String driverId, String updateUser) {
        List<String> listCode = Arrays.asList(driverId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除司机表
        int count = driverDao.deleteDriver(listCode, updateUser);
        if (0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        // 删除user表
        int counts = driverDao.deleteDriverUser(listCode, updateUser);
        if (0 == counts) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
