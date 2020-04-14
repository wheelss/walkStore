package com.xzsd.pc.client.entity;


import org.springframework.stereotype.Service;

public class ClientInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 用户编码
     */
    private String userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户登录名
     */
    private String userAcct;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 性别 0 男 1 女
     */
    private int sex;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 当前登录角色 超级管理员0，管理员1，店长2，司机3，客户4
     */
    private int role;

    /**
     * 当前登录人
     */
    private String nowUserId;

    public String getNowUserId() {
        return nowUserId;
    }

    public void setNowUserId(String nowUserId) {
        this.nowUserId = nowUserId;
    }
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDelete;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 创建者
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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
}
