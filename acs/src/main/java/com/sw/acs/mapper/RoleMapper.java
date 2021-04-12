package com.sw.acs.mapper;

import com.sw.acs.domain.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 周良聪
 */
@Mapper
public interface RoleMapper {

    /**
     * 通过用户id查询角色
     * @param userId 用户id
     * @return 角色列表
     */
    List<Role> selectRoleByUserId(Integer userId);

}
