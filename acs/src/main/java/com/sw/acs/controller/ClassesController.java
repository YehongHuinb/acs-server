package com.sw.acs.controller;


import com.sw.acs.domain.UserClasses;
import com.sw.acs.web.controller.BaseController;
import com.sw.acs.web.domain.AjaxResult;
import com.sw.acs.domain.Classes;
import com.sw.acs.service.ClassesService;
import com.sw.acs.utils.AcsSecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author 周良聪
 */
@RestController
@RequestMapping("/classes")
public class ClassesController extends BaseController {
    @Autowired
    private ClassesService classesService;

    @GetMapping("/list")
    public AjaxResult getClassesList(Classes classes){
        Integer userId = AcsSecurityUtils.getUserId();
        return AjaxResult.success(classesService.selectClassesList(classes,userId));
    }

    @GetMapping("/{classesId}")
    public AjaxResult getClassesById(@PathVariable Integer classesId){
        return AjaxResult.success(classesService.selectClassesById(classesId));
    }

    @GetMapping("/{classesId}/list")
    public AjaxResult getClassesUserList(@PathVariable Integer classesId){
        return AjaxResult.success();
    }

    @PostMapping
    public AjaxResult insertClasses(@RequestBody Classes classes){
        return toAjax(classesService.insertClasses(classes));
    }

    @PostMapping("/user")
    public AjaxResult insertClassesUser(Integer classesId){
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
