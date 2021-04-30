package com.sw.acs.service;

import com.sw.acs.domain.ClassesExam;

import java.util.List;

/**
 * @author 周良聪
 */
public interface ReleaseExamService {

    /**
     * 获取发布班级信息
     * @param examId 试卷id
     * @param userId 用户id
     * @return 班级试卷列表
     */
    List<ClassesExam> getReleaseClassesList(Integer examId, Integer userId);

    int releaseExam(ClassesExam classesExam);

    /**
     * 更新发布信息
     * @param classesExam 班级试卷信息
     * @return 结果
     */
    int updateRelease(ClassesExam classesExam);

    /**
     * 取消发布
     * @param classesId
     * @param examId
     * @return
     */
    int cancelRelease(Integer classesId, Integer examId);
}
