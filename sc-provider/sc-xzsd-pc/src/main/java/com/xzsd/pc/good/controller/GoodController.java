package com.xzsd.pc.good.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.good.entity.GoodInfo;
import com.xzsd.pc.good.service.GoodService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品管理 增删查改 一级二级分类选择 商家选择 图片上传
 *
 * @author xiekai
 * @time 2020-3-25
 */
@RestController
@RequestMapping("/goods")
public class GoodController {

    private static final Logger logger = LoggerFactory.getLogger(GoodController.class);

    @Resource
    private GoodService goodService;

    /**
     * 新增商品
     *
     * @param goodInfo
     * @return
     * @author xiekai
     * @time 2020-3-25
     */
    @PostMapping("addGoods")
    public AppResponse addGoods(GoodInfo goodInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        goodInfo.setCreateUser(userId);
        try {
            AppResponse appResponse = goodService.addGoods(goodInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-26
     */
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String goodsId) {
        String userId = SecurityUtils.getCurrentUserId();
        try {
            return goodService.deleteGoods(goodsId, userId);
        } catch (Exception e) {
            logger.error("商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-25
     */
    @PostMapping("updateGoods")
    public AppResponse updateGoods(GoodInfo goodInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        goodInfo.setUpdateUser(userId);
        try {
            return goodService.updateGoods(goodInfo);
        } catch (Exception e) {
            logger.error("修改商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品详情
     *
     * @param goodsId
     * @return AppResponse
     * @author xiekai
     * @Date 2020-03-25
     */
    @RequestMapping(value = "getGoods")
    public AppResponse getGoods(String goodsId) {
        try {
            return goodService.getGoods(goodsId);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 商品列表(分页)
     *
     * @param goodInfo
     * @return AppResponse
     * @author xiekai
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listGoods")
    public AppResponse listGoodsPage(GoodInfo goodInfo) {
        try {
            return goodService.listGoodsPage(goodInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品状态
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-25
     */
    @PostMapping("updateGoodsShelfState")
    public AppResponse updateGoodsShelfState(GoodInfo goodInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        goodInfo.setUpdateUser(userId);
        try {
            return goodService.updateGoodsShelfState(goodInfo);
        } catch (Exception e) {
            logger.error("修改商品状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 分类下拉框列表
     *
     * @param classifyId
     * @return AppResponse
     * @author xiekai
     * @Date 2020-03-26
     */
    @RequestMapping(value = "listGoodsClassify")
    public AppResponse listGoodsClassify(String classifyId) {
        try {
            return goodService.listGoodsClassify(classifyId);
        } catch (Exception e) {
            logger.error("查询商品分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
