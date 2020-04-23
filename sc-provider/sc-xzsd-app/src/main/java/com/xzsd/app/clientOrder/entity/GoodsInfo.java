package com.xzsd.app.clientOrder.entity;

/**
 * 商品类
 */
public class GoodsInfo {
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品介绍
     */
    private String goodsDescribe;
    /**
     * 商品价格
     */
    private String goodsPrice;
    /**
     * 商品图片
     */
    private String goodsImagePath;
    /**
     * 商品数量
     */
    private int cartGoodsCount;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 商品状态
     */
    private int goodsStateId;
    /**
     * 库存
     */
    private int goodsInventory;
    /**
     * 销售量
     */
    private int goodsSales;
    /**
     * 总价
     */
    private float sumPrice;
    /**
     * 商品平均星级
     */
    private int evaluateScoreAvg;

    public int getEvaluateScoreAvg() {
        return evaluateScoreAvg;
    }

    public void setEvaluateScoreAvg(int evaluateScoreAvg) {
        this.evaluateScoreAvg = evaluateScoreAvg;
    }

    public float getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(float sumPrice) {
        this.sumPrice = sumPrice;
    }

    public int getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(int goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public int getGoodsSales() {
        return goodsSales;
    }

    public void setGoodsSales(int goodsSales) {
        this.goodsSales = goodsSales;
    }

    public int getGoodsStateId() {
        return goodsStateId;
    }

    public void setGoodsStateId(int goodsStateId) {
        this.goodsStateId = goodsStateId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public int getCartGoodsCount() {
        return cartGoodsCount;
    }

    public void setCartGoodsCount(int cartGoodsCount) {
        this.cartGoodsCount = cartGoodsCount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
