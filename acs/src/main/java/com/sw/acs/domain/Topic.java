package com.sw.acs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;


/**
 * @author 周良聪
 */
public class Topic{
    /**
     * 题目id
     */
    private Integer topicId;

    /**
     * 题目
     */
    private String question;

    /**
     * 选项
     */
    private String choice;


    /**
     * 题目类型  0:单选题 1:多选题 2:判断题 3:填空题 4:简答题
     */
    private Integer topicType;

    /**
     * 正确答案
     */
    private String correctAnswer;

    /**
     * 分数
     */
    private Double score;

    /**
     * 难度  简单,中等(默认),困难
     */
    private String difficulty;

    /**
     * 答案分析
     */
    private String analysis;

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

    private static final long serialVersionUID = 1L;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public Integer getTopicType() {
        return topicType;
    }

    public void setTopicType(Integer topicType) {
        this.topicType = topicType;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
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

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", question='" + question + '\'' +
                ", choice='" + choice + '\'' +
                ", topicType=" + topicType +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", score=" + score +
                ", difficulty='" + difficulty + '\'' +
                ", analysis='" + analysis + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}