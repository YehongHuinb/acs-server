package com.sw.acs.service;

import com.sw.acs.domain.Role;
import com.sw.acs.domain.UserRole;

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
    Role selectRoleByUserId(Integer userId);

    /**
     * 获取角色数据
     * @return 角色列表
     */
    List<Role> selectRoles();

    /**
     * 插入用户角色
     * @param userRole 用户角色
     * @return 结果
     */
    int insertUserRole(UserRole userRole);
}
