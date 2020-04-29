package com.xzsd.pc.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.goodSort.entity.OneClassifyList;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderDeepenInfo;
import com.xzsd.pc.order.entity.OrderDeepenList;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
/**
 * 订单模块
 */
@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;

    /**
     * 获取订单列表
     * @param orderInfo
     * @return
     */
    public AppResponse listOrderPage(OrderInfo orderInfo) {
        if(Integer.valueOf(orderInfo.getRole()) == 0 || Integer.valueOf(orderInfo.getRole()) == 1) {
            //当角色是管理员时查看全部订单
            PageHelper.startPage(orderInfo.getPageNum(), orderInfo.getPageSize());
            List<OrderInfo> goodInfoList = orderDao.listOrderPage(orderInfo);
            PageInfo<OrderInfo> pageData = new PageInfo<OrderInfo>(goodInfoList);
            return AppResponse.success("查询成功！", pageData);
        }else{
            //当角色是店长时只看门下订单
            PageHelper.startPage(orderInfo.getPageNum(), orderInfo.getPageSize());
            List<OrderInfo> goodInfoList = orderDao.listOrderPages(orderInfo);
            PageInfo<OrderInfo> pageData = new PageInfo<OrderInfo>(goodInfoList);
            return AppResponse.success("查询成功！", pageData);
        }
    }
    /**
     * demo 修改订单状态
     * @return
     * @Author xiekai
     * @Date 2020-04-02
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(OrderInfo orderInfo) {
        List<String> listOrderId = Arrays.asList(orderInfo.getOrderId().split(","));
        List<String> listVersion = Arrays.asList(orderInfo.getVersion().split(","));
        List<OrderInfo> listUpdate = new ArrayList<>();
        String orderStateId = orderInfo.getOrderStateId();
        String updateUser = orderInfo.getUpdateUser();
        for (int i = 0; i < listOrderId.size(); i++) {
            OrderInfo orderInfo1 = new OrderInfo();
            orderInfo1.setOrderId(listOrderId.get(i));
            orderInfo1.setVersion(listVersion.get(i));
            orderInfo1.setOrderStateId(orderStateId);
            orderInfo1.setUpdateUser(updateUser);
            listUpdate.add(orderInfo1);
        }
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改轮播图状态信息
        int count = orderDao.updateOrderState(listUpdate);
        if (0 == count) {
            appResponse = AppResponse.bizError("修改订单状态失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 查询订单详情
     * @param orderId
     * @return
     * @Author xiekai
     * @Date 2020-03-26
     */
    public AppResponse getListOrder(String orderId) {
        List<OrderDeepenInfo> orderDeepenInfo = orderDao.getListOrder(orderId);
        OrderDeepenList orderDeepenList =new OrderDeepenList();
        orderDeepenList.setOrderDeepenList(orderDeepenInfo);
        return AppResponse.success("查询成功！", orderDeepenList);
    }
}
