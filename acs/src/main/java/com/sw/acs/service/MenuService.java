package com.sw.acs.service;

import com.sw.acs.domain.Menu;
import com.sw.acs.domain.vo.RouterVo;

import java.util.List;
import java.util.Set;

/**
 * @author 周良聪
 */
public interface MenuService {

    /**
     * 根据用户查询菜单树
     * @param userId 用户id
     * @return 菜单树
     */
    List<Menu> selectMenuTreeByUserId(Integer userId);
    /**
     * 根据用户ID查询权限
     * @param userId 用户id
     * @return 权限列表
     */
    Set<String> selectMenuPermsByUserId(Integer userId);

    /**
     * 构建菜单树
     * @param menus 菜单列表
     * @return 菜单树结构列表
     */
    List<Menu> buildMenuTree(List<Menu> menus);

    /**
     * 根据父节点id获取所有子节点
     * @param menus 菜单列表
     * @param parentId 父节点id
     * @return 子节点菜单列表
     */
    List<Menu> getChildrenMenu(List<Menu> menus,Integer parentId);

    /**
     * 构建前端路由
     *
     * @param menus 菜单列表
     * @return 路由列表
     */
    public List<RouterVo> buildRouters(List<Menu> menus);
}
