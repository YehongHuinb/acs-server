package com.sw.acs.controller;

import com.sw.acs.web.controller.BaseController;
import com.sw.acs.web.domain.AjaxResult;
import com.sw.acs.domain.Menu;
import com.sw.acs.domain.vo.RouterVo;
import com.sw.acs.service.MenuService;
import com.sw.acs.utils.AcsSecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 周良聪
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/routes")
    public AjaxResult getRouters(){
        Integer userId = AcsSecurityUtils.getUserId();
        List<Menu> menus = menuService.selectMenuTreeByUserId(userId);
        List<RouterVo> routerVoList = menuService.buildRouters(menus);
        return AjaxResult.success(routerVoList);
    }
}
