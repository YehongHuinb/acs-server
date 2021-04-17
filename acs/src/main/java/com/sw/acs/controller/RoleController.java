package com.sw.acs.controller;

import com.sw.acs.service.RoleService;
import com.sw.acs.web.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周良聪
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public AjaxResult getRoles(){
        return AjaxResult.success(roleService.selectRoles());
    }
}
