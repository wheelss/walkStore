package com.xzsd.app.clientGoods.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * 商品评价实体类
 */
public class GoodsEvaluateInfo {
    /**
     * 一页多少条
     */
    private int pageSize;
    /**
     * 第几页
     */
    private int pageNum;
    /**
     * 评价编号
     */
    private String evaluateId;
    /**
     * 评价商品编号
     */
    private String goodsId;
    /**
     * 评价星级
     */
    private int evaluateScore;
    /**
     * 评价内容
     */
    private String evaluateContent;
    /**
     * 评价图片
     */
    private List<ImageInfo> listImagePath;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDelete;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 当前登录用户
     */
    private String userId;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 版本号
     */
    private int version;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(String evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(int evaluateScore) {
        this.evaluateScore = evaluateScore;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public List<ImageInfo> getListImagePath() {
        return listImagePath;
    }

    public void setListImagePath(List<ImageInfo> listImagePath) {
        this.listImagePath = listImagePath;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
