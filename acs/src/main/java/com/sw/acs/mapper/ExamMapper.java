package com.sw.acs.mapper;

import com.sw.acs.domain.Exam;

import java.util.List;

/**
 * @author 周良聪
 */
public interface ExamMapper {

    List<Exam> selectExamList(Exam exam);

    /**
     * 通过试卷id查询
     * @param examId 试卷id
     * @return 试卷信息
     */
    Exam selectExamById(Integer examId);

    int insertExam(Exam exam);

    /**
     * 通过id删除试卷
     * @param examId 试卷id
     * @return 结果
     */
    int deleteExam(Integer examId);
}
