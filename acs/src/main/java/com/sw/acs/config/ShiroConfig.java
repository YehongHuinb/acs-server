package com.sw.acs.config;


import com.sw.acs.filter.JwtFilter;
import com.sw.acs.realms.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 周良聪
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager, JwtFilter jwtFilter){

        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        factoryBean.setSecurityManager(defaultWebSecurityManager);

        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        //配置系统公共资源
        filterChainDefinitionMap.put("/user/login","anon");
        filterChainDefinitionMap.put("/user/register","anon");
        filterChainDefinitionMap.put("/user/logout","logout");
        //配置系统受限资源
        filterChainDefinitionMap.put("/**","jwt");
        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        //设置过滤器
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("jwt",jwtFilter);
        factoryBean.setFilters(filterMap);

        return factoryBean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);

        //关闭session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator sessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        sessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(sessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);
        return securityManager;
    }


    @Bean
    public HashedCredentialsMatcher getHashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("md5");
        matcher.setHashIterations(1);
        return matcher;
    }

    @Bean
    public UserRealm getUserRealm(HashedCredentialsMatcher matcher){
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }

    @Bean
    public FilterRegistrationBean<Filter> jwtFilterRegistration(JwtFilter jwtFilter){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>(jwtFilter);
        filterRegistrationBean.setEnabled(false);
        return filterRegistrationBean;
    }

    @Bean
    public JwtFilter jwtFilter(){
        return new JwtFilter();
    }
    /**
     * 开启shiro注解支持
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator autoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        autoProxyCreator.setProxyTargetClass(true);
        return autoProxyCreator;
    }

    /**
     * 开启Aop注解支持
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
