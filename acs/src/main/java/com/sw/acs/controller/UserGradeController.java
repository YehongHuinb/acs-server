package com.sw.acs.controller;

import com.sw.acs.domain.User;
import com.sw.acs.domain.UserGrade;
import com.sw.acs.service.UserGradeService;
import com.sw.acs.web.controller.BaseController;
import com.sw.acs.web.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 周良聪
 */

@RestController
@RequestMapping("/user/grade")
public class UserGradeController extends BaseController {

    @Autowired
    private UserGradeService userGradeService;

    @GetMapping("/list/{classesId}/{examId}")
    public TableDataInfo getUserList(@PathVariable("classesId") Integer classesId, @PathVariable("examId") Integer examId){
        startPage();
        List<UserGrade> list = userGradeService.selectUserGradeList(classesId,examId);
        return getDataTable(list);
    }
}
