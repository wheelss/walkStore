package com.xzsd.app.clientShopCart.controller;


import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientShopCart.entity.ClientShopCartInfo;
import com.xzsd.app.clientShopCart.service.ClientShopCartService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/clientShopCart")
public class ClientShopCartController {
    @Resource
    private ClientShopCartService clientShopCartService;
    public static final Logger logger = LoggerFactory.getLogger(ClientShopCartController.class);

    /**
     * 新增购物车
     * @param clientShopCartInfo
     * @return
     * @author xiekai
     * @time 2020-4-15
     */
    @PostMapping("addShoppingCart")
    public AppResponse addShoppingCart(ClientShopCartInfo clientShopCartInfo){
        try {
            //获取当前登录人id
            String userId = SecurityUtils.getCurrentUserId();
            clientShopCartInfo.setUserId(userId);
            return clientShopCartService.addShoppingCart(clientShopCartInfo);
        }catch (Exception e){
            logger.error("新增购物车失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询购物车
     * @param clientShopCartInfo
     * @return
     * @author xiekai
     * @time 2020-4-15
     */
    @PostMapping("listShoppingCarts")
    public AppResponse listShoppingCarts(ClientShopCartInfo clientShopCartInfo){
        try {
            //获取当前登录人id
            String userId = SecurityUtils.getCurrentUserId();
            clientShopCartInfo.setUserId(userId);
            return clientShopCartService.listShoppingCarts(clientShopCartInfo);
        }catch (Exception e){
            logger.error("查询购物车列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改购物车商品购买数量
     * @param clientShopCartInfo
     * @return
     * @author xiekai
     * @time 2020-4-15
     */
    @PostMapping("updateShoppingCart")
    public AppResponse updateShoppingCart(ClientShopCartInfo clientShopCartInfo){
        try {
            //获取当前登录人id
            String userId = SecurityUtils.getCurrentUserId();
            clientShopCartInfo.setUserId(userId);
            return clientShopCartService.updateShoppingCart(clientShopCartInfo);
        }catch (Exception e){
            logger.error("修改购物车商品购买数量失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除购物车
     * @param shopCartId
     * @return
     * @author xiekai
     * @time 2020-4-15
     */
    @PostMapping("deleteShoppingCart")
    public AppResponse deleteShoppingCart(String shopCartId){
        try {
            //获取当前登录人id
            String userId = SecurityUtils.getCurrentUserId();
            return clientShopCartService.deleteShoppingCart(shopCartId, userId);
        } catch (Exception e){
            logger.error("删除购物车失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
