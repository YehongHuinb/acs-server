package com.sw.acs.service.impl;

import com.sw.acs.domain.Exam;
import com.sw.acs.domain.ExamTopic;
import com.sw.acs.domain.Topic;
import com.sw.acs.mapper.ExamMapper;
import com.sw.acs.mapper.ExamTopicMapper;
import com.sw.acs.mapper.TopicMapper;
import com.sw.acs.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 周良聪
 */
@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamMapper examMapper;

    @Autowired
    private TopicMapper topicMapper;

    @Autowired
    private ExamTopicMapper examTopicMapper;

    /**
     * 获取试卷列表
     * @param exam 试卷信息
     * @return 试卷列表
     */
    @Override
    public List<Exam> selectExamList(Exam exam) {
        return examMapper.selectExamList(exam);
    }

    /**
     * 通过试卷id查询
     *
     * @param examId 试卷id
     * @return 试卷信息
     */
    @Override
    public Exam selectExamById(Integer examId) {
        Exam exam = examMapper.selectExamById(examId);
        exam.setTopics(topicMapper.selectExamTopicListByExamId(examId));
        return exam;
    }

    /**
     * 插入试卷信息
     * @param exam 试卷信息
     * @return 结果
     */
    @Override
    public int insertExam(Exam exam) {
        exam.setCreateDate(new Date());
        exam.setUpdateDate(new Date());
        examMapper.insertExam(exam);
        List<Topic> topics = exam.getTopics();
        for (Topic topic : topics) {
            topicMapper.insertTopic(topic);
            examTopicMapper.insert(new ExamTopic(exam.getExamId(),topic.getTopicId()));
        }

        return 1;
    }

    /**
     * 修改试卷信息
     *
     * @param exam 试卷信息
     * @return 结果
     */
    @Override
    public int updateExam(Exam exam) {
        return 0;
    }
}
