package com.xzsd.app.clientGoods.entity;

/**
 * 评价图片实体类
 */
public class ImageInfo {
    /**
     * 评价编号
     */
    private String evaluateId;
    /**
     * 图片路径
     */
    private String imagePath;
    /**
     * 图片顺序
     */
    private String imageNum;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(String evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getImageNum() {
        return imageNum;
    }

    public void setImageNum(String imageNum) {
        this.imageNum = imageNum;
    }
}
