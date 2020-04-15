package com.xzsd.app.managerInfo.dao;

import com.xzsd.app.managerInfo.entity.ManagerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerInfoDao {
    /**
     * 查询店长门下司机信息
     * @param userId
     * @return
     */
    List<ManagerInfo> listManangerDrivers(@Param("userId") String userId);
}
