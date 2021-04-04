package com.sw.acs.controller;

import com.sw.acs.domain.LoginBody;
import com.sw.acs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 周良聪
 * @date: 2021/4/4 13:27
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public void login(@RequestBody LoginBody loginBody){

    }
}
