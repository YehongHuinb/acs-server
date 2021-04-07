package com.sw.acs.domain;

import java.util.List;

/**
 * @author 周良聪
 */
public class Menu {
    private static final long serialVersionUID = 1L;

    private Integer menuId;
    private String menuName;
    private String parentName;
    private Integer parentId;
    private String orderNum;
    private String path;
    private String component;
    private String isCache;
    private String visible;
    private String status;
    private String permissions;
    private String icon;
    private List<Menu> children;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getIsCache() {
        return isCache;
    }

    public void setIsCache(String isCache) {
        this.isCache = isCache;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", parentName='" + parentName + '\'' +
                ", parentId=" + parentId +
                ", orderNum='" + orderNum + '\'' +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", isCache='" + isCache + '\'' +
                ", visible='" + visible + '\'' +
                ", status='" + status + '\'' +
                ", permissions='" + permissions + '\'' +
                ", icon='" + icon + '\'' +
                ", children=" + children +
                '}';
    }
}
