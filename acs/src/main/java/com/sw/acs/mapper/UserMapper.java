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

    User selectUserById(Integer id);

    User selectUserByUserName(String account);

    List<User> selectUserList(User user);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUserById(Integer userId);
}
