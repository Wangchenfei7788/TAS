package com.wcf.tas.entity;

public class UserVO {
    private int id;

    private String userName;

    private String userPwd;

    private String userType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserVO [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + ", userType=" + userType + "]";
    }
}
