package com.sw.acs.service;

import com.sw.acs.domain.LoginBody;

/**
 * @author: 周良聪
 * @date: 2021/4/4 13:28
 */
public interface UserService {

    String login(LoginBody loginBody);
}
