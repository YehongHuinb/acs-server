package com.sw.acs.service;

import com.sw.acs.domain.Exam;
import com.sw.acs.domain.ClassesExam;
import org.apache.ibatis.annotations.Param;

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

    List<ClassesExam> selectClassesExamList(Integer classesId, Integer userId);

    /**
     * 通过试卷id查询
     * @param examId 试卷id
     * @return 试卷信息
     */
    Exam selectExamById(Integer examId);

    /**
     * 查询班级试卷
     * @param classesId 班级id
     * @param examId 试卷id
     * @return 试卷信息
     */
    Exam selectClassesExam(Integer userId, Integer classesId, Integer examId);

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

    int updateClassesExam(Exam exam, Integer classesId);

    int submitExam(Exam exam, Integer userId);

    int markExam(Exam exam);

    /**
     * 根据试卷id删除
     * @param examId 试卷id
     * @return 结果
     */
    int deleteExam(Integer examId);
}
