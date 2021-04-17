package com.sw.acs.domain;

/**
 * @author 周良聪
 */
public class ExamTopic {
    private Integer examId;
    private Integer classesId;

    public ExamTopic() {
    }

    public ExamTopic(Integer examId, Integer classesId) {
        this.examId = examId;
        this.classesId = classesId;
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

    @Override
    public String toString() {
        return "ExamTopic{" +
                "examId=" + examId +
                ", classesId=" + classesId +
                '}';
    }
}
