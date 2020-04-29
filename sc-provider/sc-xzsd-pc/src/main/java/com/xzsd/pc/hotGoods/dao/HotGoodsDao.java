package com.xzsd.pc.hotGoods.dao;

import com.xzsd.pc.hotGoods.entity.HotGoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 热门位商品模块
 */
@Mapper
public interface HotGoodsDao {
    /**
     * 统计排序数量
     *
     * @param hotGoodsInfo 热门位信息
     * @return
     */
    int countSort(HotGoodsInfo hotGoodsInfo);
    /**
     * 统计商品数量
     *
     * @param hotGoodsInfo 热门位信息
     * @return
     */
    int countGood(HotGoodsInfo hotGoodsInfo);
    /**
     * 新增热门位商品
     *
     * @param hotGoodsInfo 热门位商品信息
     * @return
     */
    int addHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 查询热门位商品信息
     *
     * @param hotGoodsId 热门位商品id
     * @return 修改结果
     */
    HotGoodsInfo getHotGoods(@Param("hotGoodsId") String hotGoodsId);

    /**
     * 获取所有热门位商品信息
     *
     * @param hotGoodsInfo 热门位商品信息
     * @return 所有热门位商品信息
     */
    List<HotGoodsInfo> listHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 修改热门位商品信息
     *
     * @param hotGoodsInfo 热门位商品信息
     * @return 修改结果
     */
    int updateHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 修改热门位商品展示数量
     * @return 修改结果
     */
    HotGoodsInfo getHotGoodsShowNum();

    /**
     * 修改热门位商品展示数量
     *
     * @param hotGoodsInfo 热门位商品信息
     * @return 修改结果
     */
    int updateHotGoodsShowNum(HotGoodsInfo hotGoodsInfo);

    /**
     * 删除热门位商品信息
     *
     * @param listCode 选中的热门位商品编号集合
     * @return
     */
    int deleteHotGoods(@Param("listCode") List<String> listCode, @Param("updateUser") String updateUser);
}
