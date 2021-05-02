package com.sw.acs.mapper;

import com.sw.acs.domain.Classes;
import com.sw.acs.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author 周良聪
 */
public interface ClassesMapper {
    /**
     * 通过班级信息和用户id查询
     * @param classes 班级信息
     * @param userId 用户id
     * @return 班级列表
     */
    List<Classes> selectClassesList(@Param("classes") Classes classes, @Param("userId") Integer userId);

    /**
     * 通过id查找
     * @param classesId 班级id
     * @return 结果
     */
    Classes selectClassesById(Integer classesId);

    /**
     * 查询班级学生列表
     * @param classesId 班级id
     * @return 用户列表
     */
    List<User> selectClassesUserList(Integer classesId);

    /**
     * 插入班级
     * @param classes 班级信息
     * @return 结果
     */
    int insertClasses(Classes classes);

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

}
