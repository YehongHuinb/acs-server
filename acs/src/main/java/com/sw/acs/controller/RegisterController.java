package com.sw.acs.controller;

import com.sw.acs.constant.UserConstants;
import com.sw.acs.domain.User;
import com.sw.acs.domain.UserRole;
import com.sw.acs.service.RoleService;
import com.sw.acs.service.UserService;
import com.sw.acs.utils.AcsSecurityUtils;
import com.sw.acs.utils.StringUtils;
import com.sw.acs.web.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周良聪
 */
@RestController
public class RegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody User user){
        if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(user.getUserName())))
        {
            return AjaxResult.error("注册'" + user.getUserName() + "'失败，登录账号已存在");
        }
        else if (StringUtils.isNotEmpty(user.getPhoneNumber())
                && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user)))
        {
            return AjaxResult.error("注册'" + user.getUserName() + "'失败，手机号码已存在");
        }

        user.setPassword(AcsSecurityUtils.encryptPassword(user.getPassword()));
        userService.insertUser(user);
        Integer userId = userService.selectUserByUserName(user.getUserName()).getUserId();
        roleService.insertUserRole(new UserRole(userId,3));
        return AjaxResult.success();
    }
}
