package com.xzsd.app.clientOrder.entity;

import java.util.List;

/**
 * 评价商品实体类
 */
public class EvaluationGoods {
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 评价内容
     */
    private String evaluateContent;
    /**
     * 评价星级
     */
    private int evaluateScore;
    /**
     * 评价图片集合
     */
    private List<EvaluationImages> imageList;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public int getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(int evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public List<EvaluationImages> getImageList() {
        return imageList;
    }

    public void setImageList(List<EvaluationImages> imageList) {
        this.imageList = imageList;
    }
}
