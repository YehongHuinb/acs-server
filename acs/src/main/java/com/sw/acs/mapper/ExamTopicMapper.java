package com.sw.acs.mapper;

import com.sw.acs.domain.ExamTopic;

import java.util.List;

/**
 * @author 周良聪
 */
public interface ExamTopicMapper {
    int insert(ExamTopic examTopic);
    int delete(ExamTopic examTopic);

    int deleteByExam(Integer examId);

    List<ExamTopic> selectByExamId(Integer examId);
}
