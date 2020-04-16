package com.xzsd.app.clientOrder.dao;

import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClientOrderDao {
    /**
     *增加数据到订单表
     * @param clientOrderInfo
     * @return
     */
    int addOrder(ClientOrderInfo clientOrderInfo);

    /**
     * 增加数据到订单明细表
     * @param clientOrderInfoList
     * @return
     */
    int addOrders(@Param("clientOrderInfoList") List<ClientOrderInfo> clientOrderInfoList);
}
