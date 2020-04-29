package com.xzsd.pc.area.dao;

import com.xzsd.pc.area.entity.AreaInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 查询省市区
 */
@Mapper
public interface AreaDao {
    /**
     * 获取所有省市区
     * @param areaInfo 省区市id
     * @return 获取所有省市区
     */
    List<AreaInfo> listArea(AreaInfo areaInfo);
}
