package com.sw.acs.shiro.matcher;

import com.sw.acs.utils.AcsSecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.springframework.stereotype.Component;

/**
 * @author 周良聪
 */
@Component
public class PasswordMatcher implements CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        SimpleAuthenticationInfo info = (SimpleAuthenticationInfo)authenticationInfo;
        String salt = new String(info.getCredentialsSalt().getBytes());
        String encryptPassword = AcsSecurityUtils.encryptPassword((String)authenticationToken.getCredentials(),salt);
        return authenticationToken.getPrincipal().toString().equals(authenticationInfo.getPrincipals().toString())
                && encryptPassword.equals(authenticationInfo.getCredentials().toString());
    }
}
