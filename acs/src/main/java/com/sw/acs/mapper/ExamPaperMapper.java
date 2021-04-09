package com.sw.acs.mapper;

import com.sw.acs.domain.ExamPaper;

/**
 * @author: ZZP
 * @time: 2021/4/8 20:02
 */
public interface ExamPaperMapper {
    /**
     * 新增作业/试卷
     * @param examPaper 作业/试卷信息
     * @return 结果
     */
    int insertExamPaper(ExamPaper examPaper);


    /**
     * 通过作业/试卷id查询
     * @param examPaperId  作业/试卷id
     * @return 结果
     */
    int selectExamPaperById(Integer examPaperId);

    /**
     * 通过作业/试卷ID删除
     * @param examPaperId 作业/试卷id
     * @return 结果
     */
    int deleteExamPaperById(Integer examPaperId);
}
