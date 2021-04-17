package com.sw.acs.service;

import com.sw.acs.domain.Exam;

import java.util.List;

/**
 * @author 周良聪
 */
public interface ExamService {
    /**
     * 获取试卷列表
     * @param exam 试卷信息
     * @return 试卷列表
     */
    List<Exam> selectExamList(Exam exam);

    /**
     * 通过试卷id查询
     * @param examId 试卷id
     * @return 试卷信息
     */
    Exam selectExamById(Integer examId);

    /**
     * 插入试卷信息
     * @param exam 试卷信息
     * @return 结果
     */
    int insertExam(Exam exam);

    /**
     * 修改试卷信息
     * @param exam 试卷信息
     * @return 结果
     */
    int updateExam(Exam exam);
}
