package com.xzsd.app.clientHome.controller;

import com.xzsd.app.clientHome.service.ClientHomeService;
import com.xzsd.app.user.controller.UserController;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/clientHome")
public class ClientHomeController {
    @Resource
    private ClientHomeService clientHomeService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 查询首页轮播图
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-14
     */
    @PostMapping("listRotationCharHome")
    public AppResponse listRotationCharHome(){
        try {
            return clientHomeService.listRotationCharHome();
        }catch (Exception e){
            logger.error("查询首页轮播图失败");
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询热门位商品
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-14
     */
    @PostMapping("listHotGoods")
    public AppResponse listHotGoods(HotGoods hotGoods){
        try {
            return clientHomeService.listHotGoods(hotGoods);
        }catch (Exception e){
            logger.error("查询首页热门位商品失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
