package com.sw.acs.domain;

import java.util.List;

/**
 * @author 周良聪
 */
public class UserInfo {
    private String userName;
    private String avatar;
    private Role role;

    public UserInfo() {
    }

    public UserInfo(String userName, String avatar, Role role) {
        this.userName = userName;
        this.avatar = avatar;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", role=" + role +
                '}';
    }
}
