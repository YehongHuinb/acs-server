package com.sw.acs.service;

import com.sw.acs.domain.Classes;
import com.sw.acs.domain.User;

import java.util.List;

/**
 * @author: ZZP
 * @time: 2021/4/7 19:58
 */
public interface ClassesService {
    /**
     * 通过班级名查询
     * @param ClassesName 班级名
     * @return 结果
     */
    Classes selectClassesByClassesName(String ClassesName);

    /**
     * 新增班级
     * @param classes 班级信息
     * @return 结果
     */
    int insertClasses(Classes classes);

    /**
     * 通过班级id删除班级
     * @param classesId 班级Id
     * @return 结果
     */
    int deleteClassesByClassesId(Integer classesId);

    /**
     * 查询班级列表
     * @param
     * @return 结果
     */
    List<Classes> getClassesList();
}
