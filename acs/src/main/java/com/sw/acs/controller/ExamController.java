package com.sw.acs.controller;

import com.sw.acs.domain.Exam;
import com.sw.acs.domain.User;
import com.sw.acs.service.ExamService;
import com.sw.acs.utils.AcsSecurityUtils;
import com.sw.acs.web.controller.BaseController;
import com.sw.acs.web.domain.AjaxResult;
import com.sw.acs.web.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 周良聪
 */
@RestController
@RequestMapping("/exam")
public class ExamController extends BaseController {
    @Autowired
    private ExamService examService;

    @GetMapping("/list")
    public TableDataInfo getUserList(Exam exam){
        startPage();
        List<Exam> list = examService.selectExamList(exam);
        return getDataTable(list);
    }

    @GetMapping("/{examId}")
    public AjaxResult getExam(@PathVariable Integer examId){
        return AjaxResult.success(examService.selectExamById(examId));
    }

    @PostMapping
    public AjaxResult insertExam(@RequestBody Exam exam){
        exam.setCreatorId(AcsSecurityUtils.getUserId());
        return toAjax(examService.insertExam(exam));
    }

    @PutMapping
    public AjaxResult updateExam(@RequestBody Exam exam){
        return toAjax(examService.updateExam(exam));
    }


}
