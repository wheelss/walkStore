package com.xzsd.app.clientGoods.dao;

import com.xzsd.app.clientGoods.entity.GoodSortInfo;
import com.xzsd.app.clientGoods.entity.GoodsEvaluateInfo;
import com.xzsd.app.clientGoods.entity.GoodsInfo;
import com.xzsd.app.clientGoods.entity.ImageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClientGoodsDao {
    /**
     * 查询商品详情
     * @param goodsId
     * @return
     */
    GoodsInfo getGoods(String goodsId);
    /**
     * 查询评价列表
     * @param goodsEvaluateInfo
     * @return
     */
    List<GoodsEvaluateInfo> listGoodsEvaluates(GoodsEvaluateInfo goodsEvaluateInfo);
    List<ImageInfo> listImage(@Param("evaluateId") String  evaluateId);
    /**
     * 查询一级商品分类
     * @return
     */
    List<GoodSortInfo> listOneGoodsClassify();
    /**
     * 查询商品二级分类级商品信息
     * @param classifyId
     * @return
     */
    List<GoodSortInfo> listGetClassGoods(@Param("classifyId") String classifyId);

}
