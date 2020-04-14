package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderDeepenInfo;
import com.xzsd.pc.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDao {

    /**
     * 获取所有订单信息
     * @param orderInfo 订单信息
     * @return 所有订单信息
     */
    List<OrderInfo> listOrderPage(OrderInfo orderInfo);
    /**
     * 修改订单状态
     * @return 修改结果
     */
    int updateOrderState(@Param(value = "listUpdate") List<OrderInfo> listUpdate);
    /**
     * 查询订单信息
     *
     * @param orderId 订单id
     * @return 修改结果
     */
    OrderDeepenInfo getListOrder(@Param("orderId") String orderId);

}
