package com.xzsd.app.manangerOrder.dao;

import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.clientOrder.entity.GoodsInfo;
import com.xzsd.app.manangerOrder.entity.ManagerOrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManagerOrderDao {
    /**
     * 修改店长订单状态
     * @param managerOrderInfo
     * @return
     */
    int updateManangerOrderState(ManagerOrderInfo managerOrderInfo);
    /**
     * 获取门店详情
     * @param userId
     * @return
     */
    ManagerOrderInfo getStore(@Param("userId") String userId);
    /**
     * 查询店长订单列表
     * @param clientOrderInfo
     * @return
     */
    List<ClientOrderInfo> getListManagerOrder(ClientOrderInfo clientOrderInfo);

    /**
     * 查询订单下的所有商品
     * @param clientOrderInfo
     * @return
     */
    List<GoodsInfo> getListOrderGoods(ClientOrderInfo clientOrderInfo);
    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    ClientOrderInfo listManagerOrderDeepen(@Param("orderId") String orderId);
}
