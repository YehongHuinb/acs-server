package com.sw.acs.service.impl;

import com.sw.acs.domain.LoginBody;
import com.sw.acs.domain.User;
import com.sw.acs.mapper.UserMapper;
import com.sw.acs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 周良聪
 * @date: 2021/4/4 13:28
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(LoginBody loginBody) {
        User user = userMapper.selectUserByUserName(loginBody.getUserName());

        if(user == null){
            return "1";
        } else if(!user.getPassword().equals(loginBody.getPassword())){
            return "1";
        }
       return "0";
    }
}
