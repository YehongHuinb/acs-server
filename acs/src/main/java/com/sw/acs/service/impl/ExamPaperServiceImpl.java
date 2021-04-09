package com.sw.acs.service.impl;

import com.sw.acs.domain.ExamPaper;
import com.sw.acs.mapper.ExamPaperMapper;
import com.sw.acs.service.ExamPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: ZZP
 * @time: 2021/4/8 20:18
 */
@Service
public class ExamPaperServiceImpl implements ExamPaperService {

    @Autowired
    private ExamPaperMapper examPaperMapper;
    /**
     * 新增作业/试卷
     * @param examPaper 作业/试卷信息
     * @return 结果
     */
    @Override
    public int insertExamPaper(ExamPaper examPaper) {
        return examPaperMapper.insertExamPaper(examPaper);
    }

    /**
     * 通过作业/试卷id查询
     * @param examPaperId  作业/试卷id
     * @return 结果
     */
    @Override
    public int selectExamPaperById(Integer examPaperId){
        return examPaperMapper.selectExamPaperById(examPaperId);
    }

    /**
     * 通过作业/试卷ID删除
     * @param examPaperId 作业/试卷id
     * @return 结果
     */
    @Override
    public int deleteExamPaperById(Integer examPaperId){
        return examPaperMapper.deleteExamPaperById(examPaperId);
    }
}
