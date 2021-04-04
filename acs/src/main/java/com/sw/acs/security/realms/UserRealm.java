package com.sw.acs.security.realms;

import com.sw.acs.security.JwtToken;
import com.sw.acs.utils.JwtUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author: 周良聪
 * @date: 2020/10/24 21:54
 */
public class UserRealm extends AuthorizingRealm {

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        String loginUserName = JwtUtils.parseToken(principal,"userName");
        if (principal == null){
            throw new AuthenticationException("token无效");
        }

        JwtUtils.verify(principal,loginUserName);

        return new SimpleAuthenticationInfo(principal,principal,getName());
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }
}
