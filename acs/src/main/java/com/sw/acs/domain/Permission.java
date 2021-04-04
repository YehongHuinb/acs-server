package com.sw.acs.domain;

/**
 * @author 周良聪
 */
public class Permission {
    private Integer permissionId;
    private String permissionCode;
    private String permissionName;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", permissionCode='" + permissionCode + '\'' +
                ", permissionName='" + permissionName + '\'' +
                '}';
    }
}
