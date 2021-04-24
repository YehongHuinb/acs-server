package com.sw.acs.controller;


import com.sw.acs.domain.Exam;
import com.sw.acs.domain.User;
import com.sw.acs.domain.UserClasses;
import com.sw.acs.web.controller.BaseController;
import com.sw.acs.web.domain.AjaxResult;
import com.sw.acs.domain.Classes;
import com.sw.acs.service.ClassesService;
import com.sw.acs.utils.AcsSecurityUtils;
import com.sw.acs.web.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author 周良聪
 */
@RestController
@RequestMapping("/classes")
public class ClassesController extends BaseController {
    @Autowired
    private ClassesService classesService;

    @GetMapping("/list")
    public TableDataInfo getExamList(Classes classes){
        startPage();
        Integer userId = AcsSecurityUtils.getUserId();
        List<Classes> list = classesService.selectClassesList(classes,userId);
        return getDataTable(list);
    }

    @GetMapping("/{classesId}")
    public AjaxResult getClassesById(@PathVariable Integer classesId){
        return AjaxResult.success(classesService.selectClassesById(classesId));
    }

    @GetMapping("/{classesId}/list")
    public TableDataInfo getClassesUserList(@PathVariable Integer classesId){
        startPage();
        List<User> list = classesService.selectClassesUserList(classesId);
        return getDataTable(list);
    }

    @PostMapping
    public AjaxResult insertClasses(@RequestBody Classes classes){
        Integer userId = AcsSecurityUtils.getUserId();
        classes.setCreatorId(userId);
        return toAjax(classesService.insertClasses(classes));
    }

    @GetMapping("/user/{classesId}")
    public AjaxResult insertClassesUser(@PathVariable Integer classesId){
        Integer userId = AcsSecurityUtils.getUserId();
        return toAjax(classesService.insertClassesUser(new UserClasses(userId,classesId)));
    }

    @PutMapping
    public AjaxResult updateClasses(@RequestBody Classes classes){
        return toAjax(classesService.updateClasses(classes));
    }

    @DeleteMapping("/{classesId}")
    public AjaxResult deleteClasses(@PathVariable Integer classesId){
        return toAjax(classesService.deleteClasses(classesId));
    }

    @DeleteMapping("/{classesId}/{userId}")
    public AjaxResult deleteClassesUser(@PathVariable("classesId") Integer classesId, @PathVariable("userId") Integer userId){
        return toAjax(classesService.deleteClassesUser(new UserClasses(userId,classesId)));
    }


    @DeleteMapping("/user/{classesId}")
    public AjaxResult deleteClassesUser(@PathVariable("classesId") Integer classesId){
        Integer userId = AcsSecurityUtils.getUserId();
        return toAjax(classesService.deleteClassesUser(new UserClasses(userId,classesId)));
    }
}
