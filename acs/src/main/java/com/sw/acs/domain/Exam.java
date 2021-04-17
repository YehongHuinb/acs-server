package com.sw.acs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.List;


/**
 * @author 周良聪
 */
public class Exam{
    /**
     * 试卷id
     */
    private Integer examId;

    /**
     * 试卷名称
     */
    private String examName;

    /**
     * 创建者id
     */
    private Integer creatorId;

    /**
     * 创建者名称
     */
    private String creatorName;

    /**
     * 答题时间(分钟)
     */
    private Integer time;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createDate;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateDate;

    /**
     * 题目数量
     */
    private Integer topicNum;

    /**
     * 总分
     */
    private Double totalScore;

    /**
     * 及格分数
     */
    private Double passMark;

    /**
     * 是否允许复制  0:不允许  1:允许(默认)
     */
    private Integer permitCopy;

    /**
     * 是否打乱题目顺序 0:不打乱(默认) 1:打乱顺序
     */
    private Integer disruptOrder;

    /**
     * 允许考生考试次数 默认1
     */
    private Integer repeatTest;

    /**
     * 是否自动评分 0:否   1:是(默认)
     */
    private Integer autoMack;

    private List<Topic> topics;

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getTopicNum() {
        return topicNum;
    }

    public void setTopicNum(Integer topicNum) {
        this.topicNum = topicNum;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public Double getPassMark() {
        return passMark;
    }

    public void setPassMark(Double passMark) {
        this.passMark = passMark;
    }

    public Integer getPermitCopy() {
        return permitCopy;
    }

    public void setPermitCopy(Integer permitCopy) {
        this.permitCopy = permitCopy;
    }

    public Integer getDisruptOrder() {
        return disruptOrder;
    }

    public void setDisruptOrder(Integer disruptOrder) {
        this.disruptOrder = disruptOrder;
    }

    public Integer getRepeatTest() {
        return repeatTest;
    }

    public void setRepeatTest(Integer repeatTest) {
        this.repeatTest = repeatTest;
    }

    public Integer getAutoMack() {
        return autoMack;
    }

    public void setAutoMack(Integer autoMack) {
        this.autoMack = autoMack;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", examName='" + examName + '\'' +
                ", creatorId=" + creatorId +
                ", creatorName='" + creatorName + '\'' +
                ", time=" + time +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", topicNum=" + topicNum +
                ", totalScore=" + totalScore +
                ", passMark=" + passMark +
                ", permitCopy=" + permitCopy +
                ", disruptOrder=" + disruptOrder +
                ", repeatTest=" + repeatTest +
                ", autoMack=" + autoMack +
                ", topics=" + topics +
                '}';
    }
}