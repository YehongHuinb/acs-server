package com.sw.acs.service.impl;

import com.sw.acs.domain.ClassesExam;
import com.sw.acs.mapper.ClassesExamMapper;
import com.sw.acs.mapper.UserGradeMapper;
import com.sw.acs.mapper.UserTopicMapper;
import com.sw.acs.service.ReleaseExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 周良聪
 */
@Service
public class ReleaseExamServiceImpl implements ReleaseExamService {

    @Autowired
    private ClassesExamMapper classesExamMapper;

    @Autowired
    private UserTopicMapper userTopicMapper;

    @Autowired
    private UserGradeMapper userGradeMapper;

    /**
     * 获取发布班级信息
     *
     * @param examId 试卷id
     * @param userId 用户id
     * @return 班级试卷列表
     */
    @Override
    public List<ClassesExam> getReleaseClassesList(Integer examId, Integer userId) {
        return classesExamMapper.selectReleaseClassesList(examId, userId);
    }

    @Override
    public int releaseExam(ClassesExam classesExam){
        classesExam.setReleaseDate(new Date());
        List<Integer> ids = classesExam.getIds();
        for (Integer id : ids) {
            classesExam.setClassesId(id);
            classesExamMapper.insert(classesExam);
        }
        return 1;
    }

    /**
     * 更新发布信息
     *
     * @param classesExam 班级试卷信息
     * @return 结果
     */
    @Override
    public int updateRelease(ClassesExam classesExam) {
        return classesExamMapper.update(classesExam);
    }

    /**
     *
     * @param classesId
     * @param examId
     * @return
     */
    @Override
    public int cancelRelease(Integer classesId, Integer examId) {
        ClassesExam classesExam = classesExamMapper.selectClassesExam(classesId,examId);
        userTopicMapper.deleteUserTopic(classesExam.getClassesId(),classesExam.getExamId());
        userGradeMapper.deleteByClassesAndExam(classesExam.getClassesId(),classesExam.getExamId());
        classesExamMapper.cancelRelease(classesId,examId);
        return 1;
    }
}
