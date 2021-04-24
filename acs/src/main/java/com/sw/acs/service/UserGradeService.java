package com.sw.acs.service;

import com.sw.acs.domain.UserGrade;

import java.util.List;

/**
 * @author 周良聪
 */
public interface UserGradeService {
    List<UserGrade> selectUserGradeList(Integer classesId,Integer examId);
}
