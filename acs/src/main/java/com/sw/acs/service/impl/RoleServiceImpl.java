package com.sw.acs.service.impl;

import com.sw.acs.domain.Role;
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
     * @return 角色列表
     */
    @Override
    public List<Role> selectRoleByUserId(Integer userId) {
        return roleMapper.selectRoleByUserId(userId);
    }
}
