package com.sw.acs.mapper;

import com.sw.acs.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 周良聪
 */
@Mapper
public interface MenuMapper {
    /**
     * 根据用户查询菜单树
     * @param userId 用户id
     * @return 菜单树
     */
    List<Menu> selectMenuTreeByUserId(Integer userId);
}
