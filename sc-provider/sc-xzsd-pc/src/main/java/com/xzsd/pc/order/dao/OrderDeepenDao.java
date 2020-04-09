package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderDeepenInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDeepenDao {
    /**
     * 查询订单信息
     *
     * @param orderId 订单id
     * @return 修改结果
     */
    OrderDeepenInfo getListOrder(@Param("orderId") String orderId);
}
