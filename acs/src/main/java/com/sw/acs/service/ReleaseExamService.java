package com.sw.acs.service;

import com.sw.acs.domain.ClassesExam;

/**
 * @author 周良聪
 */
public interface ReleaseExamService {

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
