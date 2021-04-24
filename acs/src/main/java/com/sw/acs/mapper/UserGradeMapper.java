package com.sw.acs.mapper;

import com.sw.acs.domain.UserGrade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 周良聪
 */
public interface UserGradeMapper {

    List<UserGrade> selectUserGradeList(@Param("classesId") Integer classesId, @Param("examId") Integer examId);

    UserGrade selectUserGrade(@Param("userId") Integer userId, @Param("classesId") Integer classesId, @Param("examId") Integer examId);

    int insertUserGrade(UserGrade userGrade);

    int updateUserGrade(UserGrade userGrade);

    int deleteByClassesAndExam(@Param("classesId") Integer classesId, @Param("examId") Integer examId);

    int deleteByExam(Integer examId);
}
