package com.sw.acs.service.impl;

import com.sw.acs.domain.*;
import com.sw.acs.mapper.*;
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

    @Autowired
    private ClassesExamMapper classesExamMapper;

    @Autowired
    private UserGradeMapper userGradeMapper;

    @Autowired
    private UserTopicMapper userTopicMapper;

    /**
     * 获取试卷列表
     * @param exam 试卷信息
     * @return 试卷列表
     */
    @Override
    public List<Exam> selectExamList(Exam exam) {
        return examMapper.selectExamList(exam);
    }

    @Override
    public List<ClassesExam> selectClassesExamList(Integer classesId, Integer userId) {
        return classesExamMapper.selectClassesExamList(classesId, userId);
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
     * 查询班级试卷
     *
     * @param classesId 班级id
     * @param examId    试卷id
     * @return 试卷信息
     */
    @Override
    public Exam selectClassesExam(Integer userId,Integer classesId, Integer examId) {
        Exam exam = examMapper.selectClassesExam(classesId,examId);
        exam.setTopics(topicMapper.selectExamTopicListByExamId(examId));
        exam.setUserGrade(userGradeMapper.selectUserGrade(userId,classesId,examId));
        exam.setUserTopics(userTopicMapper.selectUserTopicList(userId,classesId,examId));
        if (exam.getPublishAnswer() == 0 && exam.getTopics() != null) {
            exam.getTopics().parallelStream().forEach(topic -> topic.setCorrectAnswer(null));
        }
        if (exam.getPublishScore() == 0 && exam.getUserGrade() != null){
            exam.getUserGrade().setGrade(null);
            exam.getUserGrade().setGradeAuto(null);
        }

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
        if (topics == null) {
            return 0;
        } else {
            for (Topic topic : topics) {
                topic.setCreateDate(new Date());
                topic.setUpdateDate(new Date());
                topicMapper.insertTopic(topic);
                examTopicMapper.insert(new ExamTopic(exam.getExamId(),topic.getTopicId()));
            }
            return 1;
        }
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

    @Override
    public int updateClassesExam(Exam exam, Integer classesId) {
        ClassesExam classesExam = classesExamMapper.selectClassesExam(exam.getExamId(),classesId);
        classesExam.setStartDate(exam.getStartDate());
        classesExam.setDeadline(exam.getDeadline());
        classesExam.setPublishAnswer(exam.getPublishAnswer());
        classesExam.setPublishScore(exam.getPublishScore());

        return 0;
    }

    @Override
    public int submitExam(Exam exam, Integer userId) {
        UserGrade userGrade = exam.getUserGrade();
        userGrade.setUserId(userId);
        userGrade.setAnswerDate(new Date());
        userGrade.setExamStatus(1);
        userGrade.setMarkStatus(0);

        double grade = 0;
        for (UserTopic userTopic : exam.getUserTopics()){

            Topic topic = topicMapper.selectTopicById(userTopic.getTopicId());

            /*判断回答是否正确*/
            //填空题
            if(topic.getTopicType() == 3) {
                String[] correctAnswerArr = topic.getCorrectAnswer().split("\n");
                String[] userAnswerArr = userTopic.getUserAnswer().split("\n");
                double topicGrade = 0;
                for(int i=0; i < correctAnswerArr.length; i++){
                    if(correctAnswerArr[i].equals(userAnswerArr[i])){
                        topicGrade = topicGrade + (int) (topic.getScore() / correctAnswerArr.length);
                    }
                }

                userTopic.setUserScore(topicGrade);
                grade = grade + topicGrade;
            }
            //简答题
            else if(topic.getTopicType() == 4){
                String[] correctAnswerArr = topic.getCorrectAnswer().split("\n");
                double topicGrade = 0;
                for (String ca : correctAnswerArr) {
                    if(userTopic.getUserAnswer().contains(ca)){
                        topicGrade = topicGrade +  (int) (topic.getScore() / correctAnswerArr.length);
                    }
                }
                userTopic.setUserScore(topicGrade);
                grade = grade + topicGrade;

                //其他题型
            }else if(topic.getCorrectAnswer().equals(userTopic.getUserAnswer())){
                //评判分数
                userTopic.setUserScore(topic.getScore());
                //计算总分
                grade = grade + topic.getScore();
            }else{
                userTopic.setUserScore(0.0);
            }


            //设置为未批改状态
            userTopic.setTopicStatus("0");
            userTopic.setUserId(userId);
            userTopicMapper.insertUserTopic(userTopic);
        }

        userGrade.setGradeAuto(grade);

        Exam currentExam = examMapper.selectExamById(exam.getExamId());
        if (currentExam.getAutoMack() == 1){
            userGrade.setGrade(grade);
        }
        userGradeMapper.insertUserGrade(userGrade);
        return 1;
    }

    @Override
    public int markExam(Exam exam) {
        UserGrade userGrade = exam.getUserGrade();
        userGrade.setMarkStatus(1);
        userGrade.setMarkDate(new Date());
        userGradeMapper.updateUserGrade(userGrade);

        for (UserTopic userTopic : exam.getUserTopics()){
            userTopic.setTopicStatus("1");
            userTopicMapper.updateUserTopic(userTopic);
        }
        return 1;
    }

    /**
     * 根据试卷id删除
     *
     * @param examId 试卷id
     * @return 结果
     */
    @Override
    public int deleteExam(Integer examId) {
        userTopicMapper.deleteByExam(examId);
        userGradeMapper.deleteByExam(examId);
        classesExamMapper.deleteByExam(examId);
        examTopicMapper.deleteByExam(examId);
        examMapper.deleteExam(examId);
        return 1;
    }
}
