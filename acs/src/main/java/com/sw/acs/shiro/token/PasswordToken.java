package com.sw.acs.shiro.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author 周良聪
 */
public class PasswordToken implements AuthenticationToken {
    private String userName;
    private String password;

    @Override
    public Object getPrincipal() {
        return userName;
    }

    @Override
    public Object getCredentials() {
        return password;
    }

    public PasswordToken(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PasswordToken{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
