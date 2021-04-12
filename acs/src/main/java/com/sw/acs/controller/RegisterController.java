package com.sw.acs.controller;

import com.sw.acs.constant.UserConstants;
import com.sw.acs.domain.AjaxResult;
import com.sw.acs.domain.User;
import com.sw.acs.service.UserService;
import com.sw.acs.utils.AcsSecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 周良聪
 */
public class RegisterController extends BaseController{
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody User user){
        if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(user.getUserName()))){
            return AjaxResult.error("用户名已存在！");
        }
        String salt = AcsSecurityUtils.getSalt(12);
        user.setSalt(salt);
        user.setPassword(AcsSecurityUtils.encryptPassword(user.getPassword(),salt));
        return toAjax(userService.insertUser(user));
    }
}
