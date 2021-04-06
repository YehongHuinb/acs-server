package com.sw.acs.service.impl;

import com.sw.acs.constant.UserConstant;
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

    /**
     * 通过用户名查询
     *
     * @param userName 用户名
     * @return 结果
     */
    @Override
    public User selectUserByUserName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }

    /**
     * 检查用户名是否唯一
     *
     * @param userName 用户名
     * @return 结果
     */
    @Override
    public String checkUserNameUnique(String userName) {
        int count = userMapper.checkUserNameUnique(userName);
        return count > 1 ? UserConstant.NOT_UNIQUE : UserConstant.UNIQUE;
    }

    /**
     * 新增用户
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int updateUser(User user) {
        return 0;
    }

    /**
     * 通过用户ID删除用户
     *
     * @param id 用户id
     * @return 结果
     */
    @Override
    public int deleteUserById(Integer id) {
        return 0;
    }
}
