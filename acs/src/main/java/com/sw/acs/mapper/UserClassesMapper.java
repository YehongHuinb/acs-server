package com.sw.acs.mapper;

import com.sw.acs.domain.UserClasses;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 周良聪
 */
@Mapper
public interface UserClassesMapper {
    /**
     * 插入班级用户数据
     * @param userClasses 班级用户数据
     * @return 结果
     */
    int insert(UserClasses userClasses);

    /**
     * 删除班级用户数据
     * @param userClasses 班级用户数据
     * @return 结果
     */
    int delete(UserClasses userClasses);
}
