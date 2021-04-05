package com.sw.acs.shiro.token;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author 周良聪
 */
public class JwtToken implements AuthenticationToken {
    private String jwt;

    public JwtToken(){}

    public JwtToken(String token){
        this.jwt = token;
    }

    public String getToken() {
        return jwt;
    }

    public void setToken(String token) {
        this.jwt = token;
    }

    @Override
    public Object getPrincipal() {
        return jwt;
    }

    @Override
    public Object getCredentials() {
        return jwt;
    }
}
