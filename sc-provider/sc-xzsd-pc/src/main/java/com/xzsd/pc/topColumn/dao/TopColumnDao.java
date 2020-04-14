package com.xzsd.pc.topColumn.dao;

import com.xzsd.pc.topColumn.entity.TopColumnInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TopColumnDao {
    /**
     * 查询顶部栏
     * @param userId
     * @return
     */
    TopColumnInfo getTopColumn(@Param("userId") String userId);
}
