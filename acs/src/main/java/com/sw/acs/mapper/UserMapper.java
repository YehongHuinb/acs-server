package com.sw.acs.mapper;

import com.sw.acs.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * * 用户登陆实体
 *
 * @author 周良聪
 */
@Mapper
public interface UserMapper {

    /**
     * 通过用户ID查找用户
     * @param id 用户id
     * @return 结果
     */
    User selectUserById(Integer id);

    /**
     * 通过用户名查询
     * @param userName 用户名
     * @return 结果
     */
    User selectUserByUserName(String userName);

    /**
     * 根据条件分页查询用户列表
     * @param user 用户信息
     * @return 结果
     */
    List<User> selectUserList(User user);

    /**
     * 检查用户名是否唯一
     * @param userName 用户名
     * @return 结果
     */
    int checkUserNameUnique(String userName);

    /**
     * 校验手机号码是否唯一
     *
     * @param phoneNumber 手机号码
     * @return 结果
     */
    User checkPhoneUnique(String phoneNumber);

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
     * @param userId 用户id
     * @return 结果
     */
    int deleteUserById(Integer userId);

    /**
     * 批量删除用户
     * @param ids 用户id列表
     * @return 结果
     */
    int deleteUserByIds(List<Integer> ids);
}
