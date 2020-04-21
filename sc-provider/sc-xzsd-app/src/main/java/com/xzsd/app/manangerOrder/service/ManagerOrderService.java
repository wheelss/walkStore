package com.xzsd.app.manangerOrder.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.clientGoods.controller.ClientGoodsController;
import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.manangerOrder.dao.ManagerOrderDao;
import com.xzsd.app.manangerOrder.entity.GoodsInfo;
import com.xzsd.app.manangerOrder.entity.ManagerOrderInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ManagerOrderService {
    @Resource
    private ManagerOrderDao managerOrderDao;

    /**
     * 修改店长订单状态
     * @param managerOrderInfo
     * @return
     * @author xiekai
     * @time 2020-4-17
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateManangerOrderState(ManagerOrderInfo managerOrderInfo){
        int count = managerOrderDao.updateManangerOrderState(managerOrderInfo);
        if(count == 0){
            return AppResponse.bizError("修改订单状态失败");
        }
        return AppResponse.success("修改订单状态成功");
    }

    /**
     * 查询订单列表
     * @param clientOrderInfo
     * @return
     * @author xiekai
     * @time 2020-4-21
     */
    public AppResponse listManagerOrders(ClientOrderInfo clientOrderInfo){
        PageHelper.startPage(clientOrderInfo.getPageNum(), clientOrderInfo.getPageSize());
        List<ClientOrderInfo> orderList = managerOrderDao.listManagerOrders(clientOrderInfo);
        PageInfo<ClientOrderInfo> pageData = new PageInfo<>(orderList);
        //设置门店编号
        String storeId = managerOrderDao.getStore(clientOrderInfo.getManagerId()).getStoreId();
        clientOrderInfo.setStoreId(storeId);
        for (int i = 0 ; i < orderList.size() ; i++ ){
            //设置订单商品种类数量
            orderList.get(i).setClassCount(orderList.get(i).getGoodsList().size());
        }
        return AppResponse.success("查询订单列表成功",pageData);
    }

    /**
     * 查询订单详情
     * @param orderId
     * @return
     * @author xiekai
     * @time 2020-4-21
     */
    public AppResponse listManagerOrderDeepen(String orderId){
        ClientOrderInfo clientOrderInfo = managerOrderDao.listManagerOrderDeepen(orderId);
        clientOrderInfo.setAddress(clientOrderInfo.getProvinceName() + clientOrderInfo.getCityName() + clientOrderInfo.getAreaName() + clientOrderInfo.getAddress());
        return AppResponse.success("查询订单详情成功！",clientOrderInfo);
    }
}
