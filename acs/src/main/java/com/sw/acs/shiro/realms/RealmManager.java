package com.sw.acs.shiro.realms;

import com.sw.acs.shiro.matcher.JwtMatcher;
import com.sw.acs.shiro.matcher.PasswordMatcher;
import com.sw.acs.shiro.token.JwtToken;
import com.sw.acs.shiro.token.PasswordToken;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 周良聪
 */
@Component
public class RealmManager {

    @Autowired
    private PasswordMatcher passwordMatcher;

    @Autowired
    private JwtMatcher jwtMatcher;

    public List<Realm> initRealm(){
        List<Realm> realms = new ArrayList<>();
        EhCacheManager ehCacheManager = new EhCacheManager();

        PasswordRealm passwordRealm = new PasswordRealm();
        passwordRealm.setCredentialsMatcher(passwordMatcher);
        passwordRealm.setAuthenticationTokenClass(PasswordToken.class);
        passwordRealm.setCacheManager(ehCacheManager);
        passwordRealm.setCachingEnabled(true);
        passwordRealm.setAuthenticationCachingEnabled(true);
        passwordRealm.setAuthorizationCachingEnabled(true);
        realms.add(passwordRealm);

        JwtRealm jwtRealm = new JwtRealm();
        jwtRealm.setCredentialsMatcher(jwtMatcher);
        jwtRealm.setAuthenticationTokenClass(JwtToken.class);
        jwtRealm.setCacheManager(ehCacheManager);
        jwtRealm.setCachingEnabled(true);
        jwtRealm.setAuthenticationCachingEnabled(true);
        jwtRealm.setAuthorizationCachingEnabled(true);
        realms.add(jwtRealm);

        return Collections.unmodifiableList(realms);
    }
}
