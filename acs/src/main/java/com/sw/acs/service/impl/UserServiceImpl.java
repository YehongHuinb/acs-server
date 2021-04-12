package com.sw.acs.service.impl;

import com.sw.acs.constant.UserConstants;
import com.sw.acs.domain.User;
import com.sw.acs.mapper.UserMapper;
import com.sw.acs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 周良聪
 *
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 通过用户id查询
     *
     * @param userId 用户id
     * @return 用户信息
     */
    @Override
    public User selectUserById(Integer userId) {
        return userMapper.selectUserById(userId);
    }

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
        return count > 1 ? UserConstants.NOT_UNIQUE : UserConstants.UNIQUE;
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
        return userMapper.updateUser(user);
    }

    /**
     * 通过用户ID删除用户
     *
     * @param userId 用户id
     * @return 结果
     */
    @Override
    public int deleteUserById(Integer userId) {
        return 0;
    }

    /**
     * 批量删除用户
     *
     * @param ids 用户id列表
     * @return 结果
     */
    @Override
    public int deleteUserByIds(List<Integer> ids) {
        return 0;
    }


}
