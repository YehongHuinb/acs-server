package com.sw.acs.service;

import com.sw.acs.domain.Role;

import java.util.List;

/**
 * @author 周良聪
 */
public interface RoleService {
    /**
     * 通过用户id查询角色
     * @param userId 用户id
     * @return 角色列表
     */
    List<Role> selectRoleByUserId(Integer userId);
}
