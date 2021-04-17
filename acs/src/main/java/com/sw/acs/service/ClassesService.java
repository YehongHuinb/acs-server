package com.sw.acs.service;

import com.sw.acs.domain.Classes;
import com.sw.acs.domain.User;
import com.sw.acs.domain.UserClasses;

import java.util.List;


/**
 * @author 周良聪
 */
public interface ClassesService {

    /**
     * 通过班级信息和用户id查询
     * @param classes 班级信息
     * @param userId 用户id
     * @return 班级列表
     */
    List<Classes> selectClassesList(Classes classes, Integer userId);

    /**
     * 通过id查找
     * @param classesId 班级id
     * @return 结果
     */
    Classes selectClassesById(Integer classesId);

    /**
     * 插入班级
     * @param classes 班级信息
     * @return 结果
     */
    int insertClasses(Classes classes);

    /**
     * 插入班级用户
     * @param userClasses 班级用户信息
     * @return 结果
     */
    int insertClassesUser(UserClasses userClasses);

    /**
     * 更新班级信息
     * @param classes 班级信息
     * @return 结果
     */
    int updateClasses(Classes classes);

    /**
     * 删除班级
     * @param classesId 班级id
     * @return 结果
     */
    int deleteClasses(Integer classesId);

    /**
     * 删除班级用户
     * @param userClasses 班级用户信息
     * @return 结果
     */
    int deleteClassesUser(UserClasses userClasses);
}
