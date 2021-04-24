package com.sw.acs.mapper;

import com.sw.acs.domain.ExamTopic;

/**
 * @author 周良聪
 */
public interface ExamTopicMapper {
    int insert(ExamTopic examTopic);
    int delete(ExamTopic examTopic);

    int deleteByExam(Integer examId);
}
