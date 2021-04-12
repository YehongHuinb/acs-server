package com.sw.acs.controller;

import com.sw.acs.constant.UserConstants;
import com.sw.acs.domain.AjaxResult;
import com.sw.acs.domain.User;
import com.sw.acs.service.RoleService;
import com.sw.acs.service.UserService;
import com.sw.acs.utils.AcsSecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author 周良聪
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("#{userId}")
    public AjaxResult getUserInfo(@PathVariable Integer userId){
        AjaxResult result = AjaxResult.success();
        result.put(AjaxResult.DATA_TAG,userService.selectUserById(userId));
        result.put("roles",roleService.selectRoleByUserId(userId));
        return result;
    }


    
}
