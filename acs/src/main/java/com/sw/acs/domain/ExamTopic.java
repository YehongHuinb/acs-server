package com.sw.acs.domain;

/**
 * @author 周良聪
 */
public class ExamTopic {
    private Integer examId;
    private Integer topicId;

    public ExamTopic() {
    }

    public ExamTopic(Integer examId, Integer topicId) {
        this.examId = examId;
        this.topicId = topicId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return "ExamTopic{" +
                "examId=" + examId +
                ", topicId=" + topicId +
                '}';
    }
}
