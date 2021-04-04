package com.sw.acs.domain;

import java.util.Date;

/**
 * @author: ZZP
 * @time: 2021/4/3 17:42
 */
public class ExamPaper {
    private Integer id;
    private String name;
    private Date createDate;
    private Integer teacherId;
    private Integer classesId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    @Override
    public String toString() {
        return "examPaper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", teacherId=" + teacherId +
                ", classesId=" + classesId +
                '}';
    }
}
