package com.sw.acs.domain;

/**
 * @author 周良聪
 */
public class UserClasses {
    private Integer userId;
    private Integer classesId;

    public UserClasses() {
    }

    public UserClasses(Integer userId, Integer classesId) {
        this.userId = userId;
        this.classesId = classesId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    @Override
    public String toString() {
        return "UserClasses{" +
                "userId=" + userId +
                ", classesId=" + classesId +
                '}';
    }
}
