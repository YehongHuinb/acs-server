package com.sw.acs.domain;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author: 周良聪
 * @date: 2020/10/24 23:26
 */
public class JwtToken implements AuthenticationToken {
    private String token;

    public JwtToken(){}

    public JwtToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
