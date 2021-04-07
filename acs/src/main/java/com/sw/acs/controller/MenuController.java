package com.sw.acs.controller;

import com.sw.acs.domain.AjaxResult;
import com.sw.acs.domain.Menu;
import com.sw.acs.service.MenuService;
import com.sw.acs.utils.AcsSecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 周良聪
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController{

    @Autowired
    private MenuService menuService;




    @GetMapping("/routers")
    public AjaxResult getRouters(HttpServletRequest request){
        Integer userId = AcsSecurityUtils.getUserId(request);
        List<Menu> menus = menuService.selectMenuTreeByUserId(userId);

        return AjaxResult.success();
    }
}