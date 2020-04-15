package com.xzsd.app.clientGoods.dao;

import com.xzsd.app.clientGoods.entity.GoodSortInfo;
import com.xzsd.app.clientGoods.entity.GoodsEvaluateInfo;
import com.xzsd.app.clientGoods.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;

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
     * 查询商品评价
     * @param goodsEvaluateInfo
     * @return
     */
    List<GoodsEvaluateInfo> listGoodsEvaluates(GoodsEvaluateInfo goodsEvaluateInfo);    /**
     * 查询一级商品分类
     * @return
     */
    List<GoodSortInfo> listOneGoodsClassify();

}
