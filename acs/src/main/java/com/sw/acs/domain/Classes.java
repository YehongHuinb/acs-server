package com.sw.acs.domain;




/**
 * @author 周良聪
 */

public class Classes {

    private Integer classesId;

    private String classesName;

    private Integer creatorId;

    private String creatorName;

    private String introduction;

    private Integer peopleNum;


    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }


    @Override
    public String toString() {
        return "Classes{" +
                "classesId=" + classesId +
                ", classesName='" + classesName + '\'' +
                ", creatorId=" + creatorId +
                ", creatorName='" + creatorName + '\'' +
                ", introduction='" + introduction + '\'' +
                ", peopleNum=" + peopleNum +
                '}';
    }
}
