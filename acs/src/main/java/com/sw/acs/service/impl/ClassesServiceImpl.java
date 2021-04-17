package com.sw.acs.service.impl;

import com.sw.acs.domain.Classes;
import com.sw.acs.domain.UserClasses;
import com.sw.acs.mapper.ClassesMapper;
import com.sw.acs.mapper.UserClassesMapper;
import com.sw.acs.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 周良聪
 */
@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    @Autowired
    private UserClassesMapper userClassesMapper;


    /**
     * 通过班级信息和用户id查询
     *
     * @param classes 班级信息
     * @param userId  用户id
     * @return 班级列表
     */
    @Override
    public List<Classes> selectClassesList(Classes classes, Integer userId) {
        return classesMapper.selectClassesList(classes,userId);
    }

    /**
     * 通过id查找
     *
     * @param classesId 班级id
     * @return 结果
     */
    @Override
    public Classes selectClassesById(Integer classesId) {
        return classesMapper.selectClassesById(classesId);
    }

    /**
     * 插入班级
     *
     * @param classes 班级信息
     * @return 结果
     */
    @Override
    public int insertClasses(Classes classes) {
        return classesMapper.insertClasses(classes);
    }

    /**
     * 插入班级用户
     *
     * @param userClasses 班级用户信息
     * @return 结果
     */
    @Override
    public int insertClassesUser(UserClasses userClasses) {
        return userClassesMapper.insert(userClasses);
    }

    /**
     * 更新班级信息
     *
     * @param classes 班级信息
     * @return 结果
     */
    @Override
    public int updateClasses(Classes classes) {
        return classesMapper.updateClasses(classes);
    }

    /**
     * 删除班级
     *
     * @param classesId 班级id
     * @return 结果
     */
    @Override
    public int deleteClasses(Integer classesId) {
        return classesMapper.deleteClasses(classesId);
    }

    /**
     * 删除班级用户
     *
     * @param userClasses 班级用户信息
     * @return 结果
     */
    @Override
    public int deleteClassesUser(UserClasses userClasses) {
        return userClassesMapper.delete(userClasses);
    }
}
