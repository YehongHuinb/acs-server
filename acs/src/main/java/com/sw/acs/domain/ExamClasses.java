package com.sw.acs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.io.Serializable;
import java.util.Date;


/**
 * @author 周良聪
 */
public class ExamClasses implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 考试id
     */
    private Integer examId;

    /**
     * 班级id
     */
    private Integer classesId;

    /**
     * 考试名称
     */
    private String examName;

    /**
     * 班级名称
     */
    private String classesName;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date releaseTime;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startDate;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date deadline;

    /**
     * 是否公布答案   0:不公布   1:公布答案
     */
    private Integer publishAnswer;

    /**
     * 是否公布分数   0:不公布   1:公布
     */
    private Integer publishScore;

    /**
     * 状态 0:待批改 1:批改完成
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getClassesId() {
        return classesId;
    }

    public void setClassesId(Integer classesId) {
        this.classesId = classesId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Integer getPublishAnswer() {
        return publishAnswer;
    }

    public void setPublishAnswer(Integer publishAnswer) {
        this.publishAnswer = publishAnswer;
    }

    public Integer getPublishScore() {
        return publishScore;
    }

    public void setPublishScore(Integer publishScore) {
        this.publishScore = publishScore;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}