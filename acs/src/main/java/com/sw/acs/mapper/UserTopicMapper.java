package com.sw.acs.mapper;

import com.sw.acs.domain.UserTopic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 周良聪
 */
public interface UserTopicMapper {
    List<UserTopic> selectUserTopicList(@Param("userId") Integer userId, @Param("classesId") Integer classesId, @Param("examId") Integer examId);

    int insertUserTopic(UserTopic userTopic);

    int updateUserTopic(UserTopic userTopic);

    int deleteUserTopic(@Param("classesId") Integer classesId, @Param("examId") Integer examId);

    int deleteByExam(Integer examId);
}
