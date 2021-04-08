package com.sw.acs.domain;

import java.util.ArrayList;

/**
 * @author: ZZP
 * @time: 2021/4/3 17:39
 */
public class Classes {
    private Integer classesId;
    private Integer number;
    private Integer teacherId;
    private String classesName;

    private ArrayList<User> students;

    public ArrayList<User> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<User> students) {
        this.students = students;
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classesId=" + classesId +
                ", number=" + number +
                ", teacherId=" + teacherId +
                ", classesName='" + classesName + '\'' +
                '}';
    }
}
