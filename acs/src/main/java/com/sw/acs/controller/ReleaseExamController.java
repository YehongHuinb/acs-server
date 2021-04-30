package com.sw.acs.controller;

import com.sw.acs.domain.Classes;
import com.sw.acs.domain.ClassesExam;
import com.sw.acs.service.ReleaseExamService;
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
@RequestMapping("/release")
public class ReleaseExamController extends BaseController {
    @Autowired
    private ReleaseExamService releaseExamService;


    @GetMapping("/classes/{examId}")
    public TableDataInfo getClassesList(@PathVariable Integer examId){
        startPage();
        Integer userId = AcsSecurityUtils.getUserId();
        List<ClassesExam> list = releaseExamService.getReleaseClassesList(examId,userId);
        return getDataTable(list);
    }

    @PostMapping
    public AjaxResult releaseExam(@RequestBody ClassesExam classesExam){
        return toAjax(releaseExamService.releaseExam(classesExam));
    }

    @PutMapping
    public AjaxResult updateRelease(@RequestBody ClassesExam classesExam){
        return toAjax(releaseExamService.updateRelease(classesExam));
    }

    @DeleteMapping("/{classesId}/{examId}")
    public AjaxResult cancelRelease(@PathVariable("classesId") Integer classesId, @PathVariable("examId") Integer examId){
        return toAjax(releaseExamService.cancelRelease(classesId, examId));
    }
}
