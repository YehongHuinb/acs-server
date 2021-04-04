package com.sw.acs.domain;

/**
 * @author: ZZP
 * @time: 2021/4/3 17:39
 */
public class Classes {
    private Integer id;
    private Integer number;
    private Integer teacherId;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", number=" + number +
                ", teacherId=" + teacherId +
                ", name='" + name + '\'' +
                '}';
    }
}
