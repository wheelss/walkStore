package com.xzsd.pc.cos.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CosDao {
    /**
     *
     * @param urls
     * @return
     */
    int upload(@Param("urls") String urls);
}
