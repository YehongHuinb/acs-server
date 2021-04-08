package com.sw.acs.service.impl;

import com.sw.acs.domain.Classes;
import com.sw.acs.mapper.ClassesMapper;
import com.sw.acs.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ZZP
 * @time: 2021/4/7 19:58
 */
@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    /**
     * 通过班级名查询
     * @param ClassesName 班级名
     * @return 结果
     */
    @Override
    public Classes selectClassesByClassesName(String ClassesName) {
        return classesMapper.selectClassesByClassesName(ClassesName);
    }

    /**
     * 新增班级
     * @param classes 班级信息
     * @return 结果
     */
    @Override
    public int insertClasses(Classes classes) {
        return classesMapper.insertClasses(classes);
    }

    /**
     * 通过班级id删除班级
     * @param classesId 班级Id
     * @return 结果
     */
    @Override
    public int deleteClassesByClassesId(Integer classesId) {

        return classesMapper.deleteClassesByClassesId(classesId);
    }

    /**
     * 查询班级列表
     * @param
     * @return 结果
     */
    @Override
    public List<Classes> getClassesList() {
        return classesMapper.getClassesList();
    }

    @Override
    public List<Classes> getClassesListByTeacherId(Integer teacherId) {
        return null;
    }
}
