package com.sw.acs.controller;

import com.sw.acs.constant.UserConstants;
import com.sw.acs.domain.UserRole;
import com.sw.acs.utils.StringUtils;
import com.sw.acs.web.controller.BaseController;
import com.sw.acs.web.domain.AjaxResult;
import com.sw.acs.domain.User;
import com.sw.acs.service.RoleService;
import com.sw.acs.service.UserService;
import com.sw.acs.utils.AcsSecurityUtils;
import com.sw.acs.web.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author 周良聪
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public TableDataInfo getUserList(User user){
        startPage();
        List<User> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    @GetMapping("/{userId}")
    public AjaxResult getUserInfo(@PathVariable("userId") Integer userId){
        AjaxResult result = AjaxResult.success();
        result.put(AjaxResult.DATA_TAG,userService.selectUserById(userId));
        result.put("roles",roleService.selectRoleByUserId(userId));
        return result;
    }

    @PostMapping
    public AjaxResult insertUser(@RequestBody User user){
        if (UserConstants.NOT_UNIQUE.equals(userService.checkUserNameUnique(user.getUserName())))
        {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，登录账号已存在");
        }
        else if (StringUtils.isNotEmpty(user.getPhoneNumber())
                && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user)))
        {
            return AjaxResult.error("新增用户'" + user.getUserName() + "'失败，手机号码已存在");
        }
        String salt = AcsSecurityUtils.getSalt(12);
        user.setSalt(salt);
        user.setPassword(AcsSecurityUtils.encryptPassword(user.getPassword(),salt));
        userService.insertUser(user);
        Integer userId = userService.selectUserByUserName(user.getUserName()).getUserId();
        roleService.insertUserRole(new UserRole(userId,user.getRoleId()));
        return AjaxResult.success();
    }

    @PutMapping
    public AjaxResult updateUser(@RequestBody User user){
        if (StringUtils.isNotEmpty(user.getPhoneNumber())
                && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user)))
        {
            return AjaxResult.error("修改用户'" + user.getUserName() + "'失败，手机号码已存在");
        }

        return toAjax(userService.updateUser(user));
    }

    @PutMapping("/resetPassword")
    public AjaxResult resetPassword(@RequestBody User user){
        User currentUser = userService.selectUserById(user.getUserId());
        String salt = currentUser.getSalt();
        String password = AcsSecurityUtils.encryptPassword(user.getPassword(),salt);
        return toAjax(userService.resetUserPassword(user.getUserId(), password));
    }

    @DeleteMapping("/{userId}")
    public AjaxResult deleteUser(@PathVariable("userId") Integer userId){
        return toAjax(userService.deleteUserById(userId));
    }

    @DeleteMapping
    public AjaxResult deleteUser(@RequestBody List<Integer> ids){
        return toAjax(userService.deleteUserByIds(ids));
    }
    
}
