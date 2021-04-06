package com.sw.acs.shiro.realms;

import com.sw.acs.domain.User;
import com.sw.acs.service.UserService;
import com.sw.acs.shiro.token.PasswordToken;
import com.sw.acs.utils.AcsSecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 周良聪
 */
@Component
public class PasswordRealm extends AuthorizingRealm {
    private static Logger logger = LoggerFactory.getLogger(PasswordRealm.class);

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
        return new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
