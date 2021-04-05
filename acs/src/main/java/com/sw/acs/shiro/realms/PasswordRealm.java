package com.sw.acs.shiro.realms;

import com.sw.acs.domain.User;
import com.sw.acs.service.UserService;
import com.sw.acs.shiro.token.PasswordToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 周良聪
 */
@Component
public class PasswordRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        if (!(authenticationToken instanceof PasswordToken)) {
            return null;
        }

        if(authenticationToken.getPrincipal() == null || authenticationToken.getPrincipal() == null){
            throw new UnknownAccountException();
        }

        PasswordToken passwordToken = (PasswordToken) authenticationToken;
        User user = userService.selectUserByUserName(passwordToken.getUserName());

        if(user == null){
            return null;
        }

        return new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),getName());
    }

}
