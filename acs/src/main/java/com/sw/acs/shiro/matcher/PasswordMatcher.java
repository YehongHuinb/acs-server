package com.sw.acs.shiro.matcher;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.springframework.stereotype.Component;

/**
 * @author 周良聪
 */
@Component
public class PasswordMatcher implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        return authenticationToken.getPrincipal().toString().equals(authenticationInfo.getPrincipals().toString())
                && authenticationToken.getCredentials().toString().equals(authenticationInfo.getCredentials().toString());
    }
}
