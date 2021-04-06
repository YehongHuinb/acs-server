package com.sw.acs.service;
import com.sw.acs.domain.User;


/**
 * @author 周良聪
 */
public interface UserService {

    /**
     * 通过用户名查询
     * @param userName 用户名
     * @return 结果
     */
    User selectUserByUserName(String userName);

    /**
     * 检查用户名是否唯一
     * @param userName 用户名
     * @return 结果
     */
    String checkUserNameUnique(String userName);

    /**
     * 新增用户
     * @param user 用户信息
     * @return 结果
     */
    int insertUser(User user);

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 结果
     */
    int updateUser(User user);

    /**
     * 通过用户ID删除用户
     * @param id 用户id
     * @return 结果
     */
    int deleteUserById(Integer id);

}
