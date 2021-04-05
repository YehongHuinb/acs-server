package com.sw.acs.controller;

import com.sw.acs.domain.AjaxResult;
import com.sw.acs.shiro.token.JwtToken;
import com.sw.acs.domain.LoginBody;
import com.sw.acs.service.UserService;
import com.sw.acs.shiro.token.PasswordToken;
import com.sw.acs.utils.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;

/**
 * @author 周良聪
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody){
        System.out.println("登录");
        PasswordToken passwordToken = new PasswordToken(loginBody.getUserName(), loginBody.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(passwordToken);
        String token = JwtUtils.sign(loginBody.getUserName());
        return AjaxResult.success(token);
    }

}
