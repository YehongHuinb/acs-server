package com.sw.acs.shiro.filter;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 周良聪
 */
@Component
public class ShiroFilterChainManager {
    public Map<String, Filter> initFilters(){
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        JwtFilter jwtFilter = new JwtFilter();
        filterMap.put("jwt",jwtFilter);
        return filterMap;
    }

    public Map<String, String> initFilterChain(){
        Map<String,String> filterChain = new LinkedHashMap<>();
        filterChain.put("/user/login","anon");
        filterChain.put("/user/register","anon");
        filterChain.put("/user/logout","logout");
        filterChain.put("/**","jwt");
        return filterChain;
    }
}
