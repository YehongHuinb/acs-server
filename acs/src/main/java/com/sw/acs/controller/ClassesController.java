package com.sw.acs.controller;


import com.sw.acs.domain.AjaxResult;
import com.sw.acs.domain.Classes;
import com.sw.acs.service.ClassesService;
import com.sw.acs.utils.AcsSecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: ZZP
 * @time: 2021/4/7 20:43
 */
@RestController
@RequestMapping("/api/classes")
public class ClassesController extends BaseController {
    @Autowired
    private ClassesService classesService;

    @PostMapping("/addClasses")
    public AjaxResult addClasses(@RequestBody Classes classes , HttpServletRequest request){
        Integer userId = AcsSecurityUtils.getUserId(request);
        classes.setTeacherId(userId);
        return toAjax(classesService.insertClasses(classes));
    }
}
