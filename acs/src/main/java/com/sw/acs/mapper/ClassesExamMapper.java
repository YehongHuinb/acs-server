package com.sw.acs.mapper;

import com.sw.acs.domain.ClassesExam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 周良聪
 */
@Mapper
public interface ClassesExamMapper {
    List<ClassesExam> selectClassesExamList(@Param("classesId") Integer classesId, @Param("userId") Integer userId);


    /**
     *
     * @param id
     * @return
     */
    ClassesExam selectClassesExamById(Integer id);


    /**
     *
     * @param classesId
     * @param examId
     * @return
     */
    ClassesExam selectClassesExam(@Param("classesId") Integer classesId, @Param("examId") Integer examId);

    int insert(ClassesExam classesExam);


    int update(ClassesExam classesExam);

    /**
     * 取消发布
     * @param id id
     * @return 结果
     */
    int cancelRelease(@Param("classesId") Integer classesId, @Param("examId") Integer examId);

    int deleteByExam(Integer examId);
}
