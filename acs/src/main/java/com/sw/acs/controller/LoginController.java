package com.sw.acs.controller;

import com.sw.acs.domain.*;
import com.sw.acs.service.RoleService;
import com.sw.acs.service.UserService;
import com.sw.acs.shiro.token.PasswordToken;
import com.sw.acs.utils.AcsSecurityUtils;
import com.sw.acs.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 周良聪
 */
@RestController
public class LoginController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody){
        PasswordToken passwordToken = new PasswordToken(loginBody.getUserName(), loginBody.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(passwordToken);
        String token = JwtUtils.sign(userService.selectUserByUserName(loginBody.getUserName()));
        return AjaxResult.success("登陆成功",token);
    }

    @GetMapping("/getInfo")
    public AjaxResult getInfo(){
        Integer userId = AcsSecurityUtils.getUserId();
        User user = userService.selectUserById(userId);
        UserInfo userInfo = new UserInfo(user.getUserName(),user.getAvatar(),roleService.selectRoleByUserId(userId));
        return AjaxResult.success(userInfo);
    }

    @DeleteMapping("/logout")
    public AjaxResult logout(){
        return AjaxResult.success();
    }
}
