package com.sw.acs.realms;

import com.sw.acs.domain.JwtToken;
import com.sw.acs.domain.User;
import com.sw.acs.service.UserService;
import com.sw.acs.utils.JwtUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: 周良聪
 * @date: 2020/10/24 21:54
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 获取授权数据
     * @param
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.iterator().next();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return null;
    }

    /**
     * 获取认证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getPrincipal();
        if(JwtUtils.isExpire(token)){
            throw  new AuthenticationException("登陆状态过期，请重新登陆！");
        }

        String userName = JwtUtils.parseToken(token,"userName");
        if("".equals(userName)){
            throw  new AuthenticationException("用户名不正确！");
        }

        User user = userService.selectUserByUserName(userName);
        if(user == null){
            throw  new AuthenticationException("用户名不存在！");
        }

        String secret  = "";
        if(!JwtUtils.verify(token,userName,secret)){
            throw  new AuthenticationException("密码不正确！");
        }

        return new SimpleAuthenticationInfo(userName,token, getName());
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }
}
