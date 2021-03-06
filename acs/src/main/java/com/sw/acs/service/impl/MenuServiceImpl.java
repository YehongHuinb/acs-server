package com.sw.acs.service.impl;

import com.sw.acs.constant.UserConstants;
import com.sw.acs.domain.Menu;
import com.sw.acs.domain.vo.MetaVo;
import com.sw.acs.domain.vo.RouterVo;
import com.sw.acs.mapper.MenuMapper;
import com.sw.acs.service.MenuService;
import com.sw.acs.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 周良聪
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 根据用户查询菜单树
     *
     * @param userId 用户id
     * @return 菜单树
     */
    @Override
    public List<Menu> selectMenuTreeByUserId(Integer userId) {
        List<Menu> menus = menuMapper.selectMenuTreeByUserId(userId);
        return buildMenuTree(menus);
    }

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户id
     * @return 权限列表
     */
    @Override
    public Set<String> selectMenuPermsByUserId(Integer userId) {
        return null;
    }

    /**
     * 构建菜单树
     *
     * @param menus 菜单列表
     * @return 菜单树结构列表
     */
    @Override
    public List<Menu> buildMenuTree(List<Menu> menus) {
        List<Menu> returnList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        for (Menu menu : menus){
            tempList.add(menu.getMenuId());
        }
        for (Menu menu : menus){
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(menu.getParentId())){
                recursionFn(menus,menu);
                returnList.add(menu);
            }
        }
        if (returnList.isEmpty()){
            returnList = menus;
        }

        return returnList;
    }

    /**
     * 根据父节点id获取所有子节点
     *
     * @param menus    菜单列表
     * @param parentId 父节点id
     * @return 子节点菜单列表
     */
    @Override
    public List<Menu> getChildrenMenu(List<Menu> menus, Integer parentId) {
        List<Menu> childrenMenu = new ArrayList<>();
        for (Menu menu : menus){
            if (menu.getParentId().intValue() == parentId){
                recursionFn(menus,menu);
                childrenMenu.add(menu);
            }
        }
        return childrenMenu;
    }

    private void recursionFn(List<Menu> list, Menu menu)
    {
        // 得到子节点列表
        List<Menu> childList = getChildList(list, menu);
        menu.setChildren(childList);
        for (Menu child : childList)
        {
            if (hasChild(list, child))
            {
                recursionFn(list, child);
            }
        }
    }

    /**
     * 获取菜单子节点列表
     * @param menus 菜单列表
     * @param parentMenu 菜单
     * @return 子菜单列表
     */
    private List<Menu> getChildList(List<Menu> menus,Menu parentMenu){
        List<Menu> childList = new ArrayList<>();
        for (Menu menu : menus){
            if (menu.getParentId().intValue() == parentMenu.getMenuId().intValue()){
                childList.add(menu);
            }
        }
        return childList;
    }

    /**
     * 获取路由名称
     *
     * @param menu 菜单信息
     * @return 路由名称
     */
    public String getRouteName(Menu menu)
    {
        String routerName = StringUtils.capitalize(menu.getPath());
        // 非外链并且是一级目录（类型为目录）
        if (isMenuFrame(menu))
        {
            routerName = StringUtils.EMPTY;
        }
        return routerName;
    }

    /**
     * 获取路由地址
     *
     * @param menu 菜单信息
     * @return 路由地址
     */
    public String getRouterPath(Menu menu)
    {
        String routerPath = menu.getPath();
        // 非外链并且是一级目录（类型为目录）
        if (0 == menu.getParentId() && UserConstants.TYPE_DIR.equals(menu.getMenuType())
                && UserConstants.NO_FRAME.equals(menu.getIsFrame()))
        {
            routerPath = "/" + menu.getPath();
        }
        // 非外链并且是一级目录（类型为菜单）
        else if (isMenuFrame(menu))
        {
            routerPath = "/";
        }
        return routerPath;
    }

    /**
     * 获取组件信息
     *
     * @param menu 菜单信息
     * @return 组件信息
     */
    public String getComponent(Menu menu)
    {
        String component = UserConstants.LAYOUT;
        if (StringUtils.isNotEmpty(menu.getComponent()) && !isMenuFrame(menu))
        {
            component = menu.getComponent();
        }
        else if (StringUtils.isEmpty(menu.getComponent()) && isParentView(menu))
        {
            component = UserConstants.PARENT_VIEW;
        }
        return component;
    }

    /**
     * 是否为菜单内部跳转
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public boolean isMenuFrame(Menu menu)
    {
        return menu.getParentId() == 0 && UserConstants.TYPE_MENU.equals(menu.getMenuType())
                && menu.getIsFrame().equals(UserConstants.NO_FRAME);
    }

    /**
     * 是否为parent_view组件
     *
     * @param menu 菜单信息
     * @return 结果
     */
    public boolean isParentView(Menu menu)
    {
        return menu.getParentId() != 0 && UserConstants.TYPE_DIR.equals(menu.getMenuType());
    }

    /**
     * 判断是否有子节点
     * @param list 菜单列表
     * @param menu 菜单
     * @return 结果
     */
    private boolean hasChild(List<Menu> list, Menu menu)
    {
        return getChildList(list, menu).size() > 0;
    }

    /**
     * 构建前端路由
     *
     * @param menus 菜单列表
     * @return 路由列表
     */
    @Override
    public List<RouterVo> buildRouters(List<Menu> menus) {
        List<RouterVo> routerVoList = new ArrayList<>();
        for (Menu menu : menus){
            RouterVo routerVo = new RouterVo();
            routerVo.setName(getRouteName(menu));
            routerVo.setPath(getRouterPath(menu));
            routerVo.setComponent(getComponent(menu));
            routerVo.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon(), "1".equals(menu.getIsCache())));

            List<Menu> childrenMenu = menu.getChildren();
            if (childrenMenu != null && !childrenMenu.isEmpty() && UserConstants.TYPE_DIR.equals(menu.getMenuType())){
                routerVo.setAlwaysShow(true);
                routerVo.setRedirect("noRedirect");
                routerVo.setChildren(buildRouters(childrenMenu));
            } else if (isMenuFrame(menu)) {
                List<RouterVo> childrenList = new ArrayList<RouterVo>();
                RouterVo children = new RouterVo();
                children.setPath(menu.getPath());
                children.setComponent(menu.getComponent());
                children.setName(StringUtils.capitalize(menu.getPath()));
                children.setMeta(new MetaVo(menu.getMenuName(), menu.getIcon(), StringUtils.equals("1", menu.getIsCache())));
                childrenList.add(children);
                routerVo.setChildren(childrenList);
            }
            routerVoList.add(routerVo);
        }
        return routerVoList;
    }
}
