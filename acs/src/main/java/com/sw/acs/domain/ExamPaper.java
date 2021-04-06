package com.sw.acs.domain;

import java.util.ArrayList;
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

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }

    private ArrayList<Integer> scores;
    private ArrayList<Question> questions;

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

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "ExamPaper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", teacherId=" + teacherId +
                ", classesId=" + classesId +
                ", scores=" + scores +
                ", questions=" + questions +
                '}';
    }
}
