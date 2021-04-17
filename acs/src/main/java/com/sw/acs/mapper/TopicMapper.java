package com.sw.acs.mapper;

import com.sw.acs.domain.Topic;

import java.util.List;

/**
 * @author 周良聪
 */
public interface TopicMapper {

    List<Topic> selectExamTopicListByExamId(Integer examId);
    int insertTopic(Topic topic);
}
