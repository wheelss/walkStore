package com.xzsd.app.clientOrder.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.clientOrder.dao.ClientOrderDao;
import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.clientOrder.entity.GoodsInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClientOrderService {
    @Resource
    private ClientOrderDao clientOrderDao;
    /**
     *新增订单
     * @param clientOrderInfo
     * @return
     * @author xiekai
     * @time 2020-4-16
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(ClientOrderInfo clientOrderInfo){
        //检验是否绑定店铺邀请码
        String inviteCode = clientOrderDao.getInviteCode(clientOrderInfo);
        if("".equals(inviteCode)){
            return AppResponse.versionError("未绑定邀请码");
        }
        //生成订单id
        clientOrderInfo.setOrderId(StringUtil.getCommonCode(2));
        //分割商品id字符
        List<String> listGoodsId = Arrays.asList(clientOrderInfo.getGoodsId().split(","));
        //分割商品价格字符
        List<String> listGoodsPrice = Arrays.asList(clientOrderInfo.getGoodsPrice().split(","));
        //分割商品数量字符
        List<String> listGoodsCount = Arrays.asList(clientOrderInfo.getClientGoodsNum().split(","));
        //获取商品库存
        List<GoodsInfo> listInventory = clientOrderDao.getInventory(listGoodsId);
        //订单明细表list
        List<ClientOrderInfo> clientOrderInfoList = new ArrayList<>();
        //这个商品总数量
        int goodsCount = 0;
        //这个商品总价格
        int theGoodsAllPrice = 0;
        //遍历商品,计算出商品价格和购买数量
        for (int i = 0; i < listGoodsId.size() ; i++) {
            //判断当前商品购买数量是否超过商品库存
            if(listInventory.get(i).getGoodsInventory() < Integer.valueOf(listGoodsCount.get(i))){
                return AppResponse.versionError("购买数量超过库存",listInventory.get(i).getGoodsName());
            }
            //库存数量减去当前购买的数量
            listInventory.get(i).setGoodsInventory(listInventory.get(i).getGoodsInventory() - Integer.valueOf(listGoodsCount.get(i)));
            //库存为0时,设置商品状态为售罄
            if(listInventory.get(i).getGoodsInventory() == 0){
                listInventory.get(i).setGoodsStateId(0);
            }
            //赋值为当前商品购买数量
            listInventory.get(i).setCartGoodsCount(Integer.valueOf(listGoodsCount.get(i)));
            //更新商品库存,销售量,商品状态
            int update = clientOrderDao.update(listInventory.get(i));
            if(0 == update){
                return AppResponse.versionError("下单失败,请重试",listInventory.get(i).getGoodsName());
            }
            //总数量
            goodsCount = goodsCount + Integer.valueOf(listGoodsCount.get(i));
            //总价格
            theGoodsAllPrice = theGoodsAllPrice + Integer.valueOf(listGoodsPrice.get(i)) * Integer.valueOf(listGoodsCount.get(i));
            //初始化设置订单明细表数据
            ClientOrderInfo orderInfo = new ClientOrderInfo();
            //生成订单明细表Id
            orderInfo.setOrderGoodsId(StringUtil.getCommonCode(2));
            //给订单明细表订单id赋值为订单表id
            orderInfo.setOrderId(clientOrderInfo.getOrderId());
            //给订单明细表订单商品id赋值为当前商品id
            orderInfo.setGoodsId(listGoodsId.get(i));
            //给订单明细表订单用户id赋值为当前用户id
            orderInfo.setUserId(clientOrderInfo.getUserId());
            //给订单明细表订单数量赋值为当前商数量
            orderInfo.setClientGoodsNum(listGoodsCount.get(i));
            ////给订单明细表订单总价赋值为当前商品数量乘与价格
            int totalPrice = Integer.valueOf(listGoodsPrice.get(i)) * Integer.valueOf(listGoodsCount.get(i));
            //给订单明细表总价赋值
            orderInfo.setTheGoodsAllPrice(String.valueOf(totalPrice));
            clientOrderInfoList.add(orderInfo);
        }
        //设置订单总数
        clientOrderInfo.setOrderAllGoodsCount(goodsCount);
        //设置订单总价
        clientOrderInfo.setOrderAllCost(String.valueOf(theGoodsAllPrice));
        //增加数据到订单表
        int count = clientOrderDao.addOrder(clientOrderInfo);
        //增加数据到订单明细表
        int counts = clientOrderDao.addOrders(clientOrderInfoList);
        if(0 == count || 0 == counts){
            return AppResponse.bizError("新增订单失败");
        }
        return AppResponse.success("新增订单成功");
    }
    /**
     *修改订单状态
     * @param clientOrderInfo
     * @return
     * @author xiekai
     * @time 2020-4-17
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(ClientOrderInfo clientOrderInfo){
        int count = clientOrderDao.updateOrderState(clientOrderInfo);
        if(0 == count){
            return AppResponse.bizError("修改订单状态失败");
        }
        return AppResponse.success("修改订单状态成功");
    }
    /**
     *查询订单评价商品信息列表
     * @param orderId
     * @return
     * @author xiekai
     * @time 2020-4-17
     */
    public AppResponse listGoodsForEvaluate(String orderId){
        List<GoodsInfo> goodsList = clientOrderDao.listGoodsForEvaluate(orderId);
        if(goodsList.size() == 0){
            return AppResponse.bizError("查询订单评价列表失败");
        }
        return AppResponse.success("查询订单评价列表成功", goodsList);
    }
    /**
     *查询订单列表
     * @param clientOrderInfo
     * @return
     * @author xiekai
     * @time 2020-4-21
     */
    public AppResponse listOrder(ClientOrderInfo clientOrderInfo){
        PageHelper.startPage(clientOrderInfo.getPageNum(), clientOrderInfo.getPageSize());
        List<ClientOrderInfo> orderList = clientOrderDao.listOrder(clientOrderInfo);
        PageInfo<ClientOrderInfo> pageData = new PageInfo<>(orderList);
        for (int i = 0 ; i <orderList.size() ; i++ ){
            orderList.get(i).setClassCount(orderList.get(i).getGoodsList().size());
        }
        return AppResponse.success("查询订单列表成功",pageData);
    }
    /**
     *查询订单详情
     * @param orderId
     * @return
     * @author xiekai
     * @time 2020-4-21
     */
    public AppResponse listOrderDeepen(String orderId) {
        ClientOrderInfo clientOrderInfo = clientOrderDao.listOrderDeepen(orderId);
        clientOrderInfo.setAddress(clientOrderInfo.getProvinceName() + clientOrderInfo.getCityName() + clientOrderInfo.getAreaName() + clientOrderInfo.getAddress());
        return AppResponse.success("查询订单详情成功！", clientOrderInfo);
    }
}

