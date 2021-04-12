package com.sw.acs.controller;

import com.sw.acs.domain.AjaxResult;
import com.sw.acs.domain.ExamPaper;
import com.sw.acs.service.ExamPaperService;
import com.sw.acs.utils.AcsSecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: ZZP
 * @time: 2021/4/8 20:42
 */
@RestController
@RequestMapping("/examPaper")
public class ExamPaperController extends BaseController {
    @Autowired
    private ExamPaperService examPaperService;

    @PostMapping("/addExamPaper")
    public AjaxResult addExamPaper(@RequestBody ExamPaper examPaper){
        Integer userId = AcsSecurityUtils.getUserId();
        examPaper.setUserId(userId);
        return toAjax(examPaperService.insertExamPaper(examPaper));
    }
}
