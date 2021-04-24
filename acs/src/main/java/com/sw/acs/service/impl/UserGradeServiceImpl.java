package com.sw.acs.service.impl;

import com.sw.acs.domain.UserGrade;
import com.sw.acs.mapper.UserGradeMapper;
import com.sw.acs.service.UserGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 周良聪
 */
@Service
public class UserGradeServiceImpl implements UserGradeService {

    @Autowired
    private UserGradeMapper userGradeMapper;

    @Override
    public List<UserGrade> selectUserGradeList(Integer classesId, Integer examId) {
        return userGradeMapper.selectUserGradeList(classesId,examId);
    }
}
