package com.sw.acs.controller;

import com.sw.acs.domain.LoginBody;
import com.sw.acs.service.UserService;
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
public class UserController {
    @Autowired
    private UserService userService;

    public void login(@RequestBody LoginBody loginBody){
        Subject subject = SecurityUtils.getSubject();

    }

}
