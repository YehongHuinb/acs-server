package com.sw.acs.shiro.matcher;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.sw.acs.domain.User;
import com.sw.acs.utils.JwtUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.springframework.stereotype.Component;

/**
 * @author 周良聪
 */
@Component
public class JwtMatcher implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        String jwt = (String)authenticationToken.getCredentials();
        User user = new User();
        user.setId(Integer.parseInt(JwtUtils.parseToken(jwt,"userId")));
        user.setUserName(JwtUtils.parseToken(jwt,"userName"));
        try{
            JwtUtils.verify(jwt,user);
        } catch (JWTVerificationException e){
            return false;
        }
        return true;
    }
}
