package com.xzsd.pc.hotGoods.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.hotGoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotGoods.service.HotGoodsService;
import com.xzsd.pc.rotation.controller.RotationController;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hotGoods")
public class HotGoodsController {
    @Resource
    private HotGoodsService hotGoodsService;

    private static final Logger logger = LoggerFactory.getLogger(HotGoodsController.class);


    /**
     * 新增热门位商品
     * @return
     * @author xiekai
     * @time 2020-4-9
     */
    @PostMapping("addHotGoods")
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        hotGoodsInfo.setCreateUser(userId);
        try {
            AppResponse appResponse = hotGoodsService.addHotGoods(hotGoodsInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("热门位商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门位商品详情
     *
     * @param hotGoodsId
     * @return AppResponse
     * @author xiekai
     * @Date 2020-03-25
     */
    @RequestMapping(value = "getHotGoods")
    public AppResponse getHotGoods(String hotGoodsId) {
        try {
            return hotGoodsService.getHotGoods(hotGoodsId);
        } catch (Exception e) {
            logger.error("热门位商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 热门位商品列表(分页)
     *
     * @param hotGoodsInfo
     * @return AppResponse
     * @author xiekai
     * @Date 2020-04-09
     */
    @RequestMapping(value = "listHotGoods")
    public AppResponse listHotGoods(HotGoodsInfo hotGoodsInfo) {
        try {
            return hotGoodsService.listHotGoods(hotGoodsInfo);
        } catch (Exception e) {
            logger.error("查询热门位商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改热门位商品
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-9
     */
    @PostMapping("updateHotGoods")
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        hotGoodsInfo.setUpdateUser(userId);
        try {
            return hotGoodsService.updateHotGoods(hotGoodsInfo);
        } catch (Exception e) {
            logger.error("修改热门位商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询热门位商品展示数量
     *
     * @return AppResponse
     * @author xiekai
     * @Date 2020-04-09
     */
    @RequestMapping(value = "getHotGoodsShowNum")
    public AppResponse getHotGoodsShowNum() {
        try {
            return hotGoodsService.getHotGoodsShowNum();
        } catch (Exception e) {
            logger.error("热门位商品展示数量查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改热门位商品展示数量
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-9
     */
    @PostMapping("updateHotGoodsShowNum")
    public AppResponse updateHotGoodsShowNum(HotGoodsInfo hotGoodsInfo) {
        String userId = SecurityUtils.getCurrentUserId();
        hotGoodsInfo.setUpdateUser(userId);
        try {
            return hotGoodsService.updateHotGoodsShowNum(hotGoodsInfo);
        } catch (Exception e) {
            logger.error("修改热门位商品展示数量错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除热门位商品
     *
     * @return AppResponse
     * @author xiekai
     * @time 2020-4-9
     */
    @PostMapping("deleteHotGoods")
    public AppResponse deleteHotGoods(String hotGoodsId) {
        String userId = SecurityUtils.getCurrentUserId();
        try {
            return hotGoodsService.deleteHotGoods(hotGoodsId, userId);
        } catch (Exception e) {
            logger.error("热门位商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
