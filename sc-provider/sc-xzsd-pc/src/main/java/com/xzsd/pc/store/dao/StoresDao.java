package com.xzsd.pc.store.dao;

import com.xzsd.pc.store.entity.StoresInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 门店模块
 */
@Mapper
public interface StoresDao {
    /**
     * 统计店长账号数量
     *
     * @param storesInfo 门店信息
     * @return
     */
    int countUserId(StoresInfo storesInfo);
    /**
     * 统计店长账号是否被使用
     *
     * @param storesInfo 门店信息
     * @return
     */
    int countUserUsed(StoresInfo storesInfo);
    /**
     * 新增门店
     *
     * @param storesInfo 门店信息
     * @return
     */
    int addStore(StoresInfo storesInfo);
    /**
     * 查询门店信息
     *
     * @param storeId 门店id
     * @return 修改结果
     */
    StoresInfo getStore(@Param("storeId") String storeId);
    /**
     * 获取所有门店信息
     *
     * @param storesInfo 门店信息
     * @return 所有门店信息
     */
    List<StoresInfo> listStores(StoresInfo storesInfo);
    /**
     * 获取当前登录店长门店信息
     *
     * @param storesInfo 门店信息
     * @return 所有当前登录店长门店信息信息
     */
    List<StoresInfo> listStoresManger(StoresInfo storesInfo);
    /**
     * 修改门店信息
     *
     * @param storesInfo 门店信息
     * @return 修改结果
     */
    int updateStore(StoresInfo storesInfo);

    /**
     * 删除门店信息
     *
     * @param listCode 选中的门店编号集合
     * @return
     */
    int deleteStore(@Param("listCode") List<String> listCode, @Param("updateUser") String updateUser);
}
