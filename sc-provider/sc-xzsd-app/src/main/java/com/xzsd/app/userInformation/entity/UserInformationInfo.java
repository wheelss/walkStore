package com.xzsd.app.userInformation.entity;

/**
 * 用户信息实体类
 */
public class UserInformationInfo {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户头像url
     */
    private String userImage;
    /**
     * 角色
     */
    private String role;
    /**
     * 门店编号：当角色编号为2或4的时候查出来不显示（存起来后面需要）
     */
    private String storeId;
    /**
     * 门店名称：当角色编号为2的时候显示，当为4的时候查出来不显示（存起来后面需要）
     */
    private String storeName;
    /**
     * 门店邀请码：当角色编号为2的时候显示
     */
    private String inviteCode;
    /**
     * 地址：当角色编号为2的时候显示，当为4的时候查出来不显示
     */
    private String address;
    /**
     * 司机电话：当角色编号为3的时候显示
     */
    private String phone;
    /**
     * 司机名称
     */
    private String driverName;
    /**
     * 版本号：当角色编号为2、3的时候有返回数据，不显示
     */
    private String version;
    /**
     * 用户原密码
     */
    private String userPassword;
    /**
     * 用户新密码
     */
    private String userNewPassword;
    /**
     * 省名
     */
    private String provinceName;
    /**
     * 市名
     */
    private String cityName;
    /**
     * 区名
     */
    private String areaName;
    /**
     * 当前登录人id
     */
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNewPassword() {
        return userNewPassword;
    }

    public void setUserNewPassword(String userNewPassword) {
        this.userNewPassword = userNewPassword;
    }
}
