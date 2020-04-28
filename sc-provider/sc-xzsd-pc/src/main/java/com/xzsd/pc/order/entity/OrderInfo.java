package com.xzsd.pc.order.entity;

/**
 * 订单实体类
 */
public class OrderInfo {
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 门店编号
     */
    private String storeId;
    /**
     * 订单总价
     */
    private String orderAllCost;
    /**
     * 订单状态编号
     */
    private String userId;
    /**
     * 客户编号
     */
    private String orderStateId;
    /**
     * 付款时间
     */
    private String payTime;
    /**
     * 优惠金额
     */
    private String reducedAllPrice;
    /**
     * 订单备注
     */
    private String orderComment;
    /**
     * 收件人姓名
     */
    private String userName;
    /**
     * 收件人电话
     */
    private String phone;
    /**
     * 删除标记
     */
    private int isDelete;
    /**
     * 创作时间
     */
    private String createTime;
    /**
     * 创作者
     */
    private String createUser;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 更新者
     */
    private String updateUser;
    /**
     * 版本号
     */
    private String version;
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 收件人姓名
     */
    private String recipientName;
    /**
     * 收件人电话
     */
    private String recipientPhone;
    /**
     * 当前登录角色
     */
    private String role;
    /**
     * 当前登录人
     */
    private String nowUserId;
    /**
     * 开始时间
     */
    private String payTimeStart;
    /**
     * 结束时间
     */
    private String payTimeEnd;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getOrderAllCost() {
        return orderAllCost;
    }

    public void setOrderAllCost(String orderAllCost) {
        this.orderAllCost = orderAllCost;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(String orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getReducedAllPrice() {
        return reducedAllPrice;
    }

    public void setReducedAllPrice(String reducedAllPrice) {
        this.reducedAllPrice = reducedAllPrice;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

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

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNowUserId() {
        return nowUserId;
    }

    public void setNowUserId(String nowUserId) {
        this.nowUserId = nowUserId;
    }

    public String getPayTimeStart() {
        return payTimeStart;
    }

    public void setPayTimeStart(String payTimeStart) {
        this.payTimeStart = payTimeStart;
    }

    public String getPayTimeEnd() {
        return payTimeEnd;
    }

    public void setPayTimeEnd(String payTimeEnd) {
        this.payTimeEnd = payTimeEnd;
    }
}
