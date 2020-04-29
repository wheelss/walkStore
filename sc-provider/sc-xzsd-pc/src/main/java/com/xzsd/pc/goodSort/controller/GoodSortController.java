package com.xzsd.pc.goodSort.controller;


import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goodSort.entity.GoodSortInfo;
import com.xzsd.pc.goodSort.service.GoodSortService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品分类模块
 */
@RestController
@RequestMapping("/goodsClassify")
public class GoodSortController {

    private static final Logger logger = LoggerFactory.getLogger(GoodSortController.class);

    @Resource
    private GoodSortService goodSortService;

    /**
     * 新增商品分类
     *
     * @param goodSortInfo
     * @return AppResponse
     * @author xiekai
     * @time 2020-3-25
     */
    @PostMapping("addGoodsClassify")
    public AppResponse addGoodsClassify(GoodSortInfo goodSortInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        goodSortInfo.setCreateUser(userId);
        try {
            AppResponse appResponse = goodSortService.addGoodsClassify(goodSortInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品分类新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品分类详情
     * @param classifyId
     * @return AppResponse
     * @author xiekai
     * @Date 2020-4-6
     */
    @RequestMapping(value = "getGoodsClassify")
    public AppResponse getGoodsClassify(String classifyId) {
        try {
            return goodSortService.getGoodsClassify(classifyId);
        } catch (Exception e) {
            logger.error("商品分类查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 商品分类列表(分页)
     * @param goodSortInfo
     * @return AppResponse
     * @author xiekai
     * @Date 2020-04-06
     */
    @RequestMapping(value = "listAllGoodsClassify")
    public AppResponse listAllGoodsClassify(GoodSortInfo goodSortInfo) {
        try {
            return goodSortService.listAllGoodsClassify(goodSortInfo);
        } catch (Exception e) {
            logger.error("查询商品分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品分类信息
     * @param goodSortInfo
     * @return
     */
    @PostMapping("updateGoodsClassify")
    public AppResponse updateGoodsClassify(GoodSortInfo goodSortInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        goodSortInfo.setUpdateUser(userId);
        try {
            return goodSortService.updateGoodsClassify(goodSortInfo);
        } catch (Exception e) {
            logger.error("修改商品分类信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品分类
     * @param classifyId
     * @return
     */
    @PostMapping("deleteGoodsClassify")
    public AppResponse deleteGoodsClassify(String classifyId) {
        String userId = SecurityUtils.getCurrentUserId();
        try {
            return goodSortService.deleteGoodsClassify(classifyId,userId);
        } catch (Exception e) {
            logger.error("商品分类删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
