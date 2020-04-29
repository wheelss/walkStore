package com.xzsd.pc.good.entity;

import com.xzsd.pc.goodSort.entity.GoodSortInfo;

import java.util.List;

/**
 * 封装文档名
 */
public class GoodsClassifyList {

    private List<GoodSortInfo> goodsClassifyList;

    public List<GoodSortInfo> getGoodsClassifyList() {
        return goodsClassifyList;
    }

    public void setGoodsClassifyList(List<GoodSortInfo> goodsClassifyList) {
        this.goodsClassifyList = goodsClassifyList;
    }
}
