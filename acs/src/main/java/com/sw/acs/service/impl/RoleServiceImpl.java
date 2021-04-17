package com.sw.acs.service.impl;

import com.sw.acs.domain.Role;
import com.sw.acs.domain.UserRole;
import com.sw.acs.mapper.RoleMapper;
import com.sw.acs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 周良聪
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 通过用户id查询角色
     *
     * @param userId 用户id
     * @return 角色
     */
    @Override
    public Role selectRoleByUserId(Integer userId) {
        return roleMapper.selectRoleByUserId(userId);
    }

    /**
     * 获取角色数据
     *
     * @return 角色列表
     */
    @Override
    public List<Role> selectRoles() {
        return roleMapper.selectRoles();
    }

    /**
     * 插入用户角色
     *
     * @param userRole 用户角色
     * @return 结果
     */
    @Override
    public int insertUserRole(UserRole userRole) {
        return roleMapper.insertUserRole(userRole);
    }
}
