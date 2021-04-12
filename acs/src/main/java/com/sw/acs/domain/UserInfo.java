package com.sw.acs.domain;

import java.util.List;

/**
 * @author 周良聪
 */
public class UserInfo {
    private String userName;
    private String avatar;
    private List<Role> roles;

    public UserInfo() {
    }

    public UserInfo(String userName, String avatar, List<Role> roles) {
        this.userName = userName;
        this.avatar = avatar;
        this.roles = roles;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", roles=" + roles +
                '}';
    }
}
