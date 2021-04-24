package com.sw.acs.controller;

import com.sw.acs.domain.Exam;
import com.sw.acs.domain.ClassesExam;
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
    public TableDataInfo getExamList(Exam exam){
        startPage();
        List<Exam> list = examService.selectExamList(exam);
        return getDataTable(list);
    }

    @GetMapping("/{classesId}/list")
    public TableDataInfo getClassesExamList(@PathVariable Integer classesId){
        startPage();
        Integer userId = AcsSecurityUtils.getUserId();
        List<ClassesExam> list = examService.selectClassesExamList(classesId, userId);
        return getDataTable(list);
    }

    @GetMapping("/{examId}")
    public AjaxResult getExam(@PathVariable Integer examId){
        return AjaxResult.success(examService.selectExamById(examId));
    }

    @GetMapping("/{classesId}/{examId}")
    public AjaxResult getClassesExam(@PathVariable("classesId") Integer classesId, @PathVariable("examId") Integer examId){
        Integer userId = AcsSecurityUtils.getUserId();
        return AjaxResult.success(examService.selectClassesExam(userId,classesId,examId));
    }

    @GetMapping("/{classesId}/{examId}/{userId}")
    public AjaxResult getUserExam(@PathVariable("classesId") Integer classesId, @PathVariable("examId") Integer examId,
                                  @PathVariable("userId") Integer userId){
        return AjaxResult.success(examService.selectClassesExam(userId,classesId,examId));
    }

    @PostMapping("/submit")
    public AjaxResult submitExam(@RequestBody Exam exam){
        Integer userId = AcsSecurityUtils.getUserId();
        return toAjax(examService.submitExam(exam,userId));
    }

    @PostMapping("/mark")
    public AjaxResult markExam(@RequestBody Exam exam){
        return  toAjax(examService.markExam(exam));
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


    @PutMapping("/classes/{classesId}")
    public AjaxResult updateClassesExam(@RequestBody Exam exam, @PathVariable Integer classesId){
        return toAjax(examService.updateClassesExam(exam,classesId));
    }

    @DeleteMapping("/{examId}")
    public AjaxResult deleteExam(@PathVariable Integer examId){
        return toAjax(examService.deleteExam(examId));
    }
}
