package com.xzsd.pc.area.dao;

import com.xzsd.pc.area.entity.AreaInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AreaDao {
    /**
     * 获取所有省市区
     *
     * @param areaInfo 获取所有省市区
     * @return 获取所有省市区
     */
    List<AreaInfo> listArea(AreaInfo areaInfo);
}
