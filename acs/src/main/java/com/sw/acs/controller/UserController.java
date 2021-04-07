package com.sw.acs.controller;

import com.sw.acs.constant.UserConstant;
import com.sw.acs.domain.AjaxResult;
import com.sw.acs.domain.User;
import com.sw.acs.domain.LoginBody;
import com.sw.acs.service.UserService;
import com.sw.acs.shiro.token.PasswordToken;
import com.sw.acs.utils.AcsSecurityUtils;
import com.sw.acs.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 周良聪
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody){
        AjaxResult result = AjaxResult.success();
        PasswordToken passwordToken = new PasswordToken(loginBody.getUserName(), loginBody.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(passwordToken);
        String token = JwtUtils.sign(userService.selectUserByUserName(loginBody.getUserName()));
        result.put("Authorization",token);
        return result;
    }

    @PostMapping("/register")
    public AjaxResult register(@RequestBody User user){
        if (UserConstant.NOT_UNIQUE.equals(userService.checkUserNameUnique(user.getUserName()))){
            return AjaxResult.error("用户名已存在！");
        }
        String salt = AcsSecurityUtils.getSalt(12);
        user.setSalt(salt);
        user.setPassword(AcsSecurityUtils.encryptPassword(user.getPassword(),salt));
        return toAjax(userService.insertUser(user));
    }

}
