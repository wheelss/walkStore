package com.xzsd.app.clientOrder.dao;

import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.clientOrder.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClientOrderDao {
    /**
     * 获取客户店铺邀请码
     * @param clientOrderInfo 订单信息
     * @return
     */
    String getInviteCode(ClientOrderInfo clientOrderInfo);
    /**
     *获取商品库存
     * @param listGoodsId 商品id集合
     * @return
     */
    List<GoodsInfo> getInventory(@Param("listGoodsId") List<String> listGoodsId);
    /**
     *更新商品库存,销售量,商品状态
     * @param goodsInfo
     * @return
     */
    int update(GoodsInfo goodsInfo);
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
    /**
     * 修改订单状态
     * @param clientOrderInfo
     * @return
     */
    int updateOrderState(ClientOrderInfo clientOrderInfo);
    /**
     *查询订单评价商品信息列表
     * @param orderId
     * @return
     */
    List<GoodsInfo> listGoodsForEvaluate(@Param("orderId") String orderId);
    /**
     * 查询订单列表
     * @param clientOrderInfo
     * @return
     */
    List<ClientOrderInfo> listOrder(ClientOrderInfo clientOrderInfo);
    /**
     * 查询商品
     * @param clientOrderInfo
     * @return
     */
    List<GoodsInfo> orderGoods(ClientOrderInfo clientOrderInfo);
    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    ClientOrderInfo listOrderDeepen(@Param("orderId") String orderId);
}
