package com.sw.acs.service;
import com.sw.acs.domain.User;


/**
 * @author 周良聪
 */
public interface UserService {

    User selectUserByUserName(String userName);

}
