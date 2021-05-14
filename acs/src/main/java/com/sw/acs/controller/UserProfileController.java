package com.sw.acs.controller;

import com.sw.acs.config.AcsConfig;
import com.sw.acs.constant.UserConstants;
import com.sw.acs.domain.User;
import com.sw.acs.service.UserService;
import com.sw.acs.utils.AcsSecurityUtils;
import com.sw.acs.utils.StringUtils;
import com.sw.acs.utils.file.FileUploadUtils;
import com.sw.acs.web.controller.BaseController;
import com.sw.acs.web.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 周良聪
 */
@RestController
@RequestMapping("/user/profile")
public class UserProfileController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 个人信息
     */
    @GetMapping
    public AjaxResult profile()
    {
        Integer userId = AcsSecurityUtils.getUserId();
        return AjaxResult.success(userService.selectUserById(userId));
    }

    /**
     * 修改用户
     */
    @PutMapping
    public AjaxResult updateProfile(@RequestBody User user)
    {
        if (StringUtils.isNotEmpty(user.getPhoneNumber())
                && UserConstants.NOT_UNIQUE.equals(userService.checkPhoneUnique(user)))
        {
            return AjaxResult.error("修改用户'" + user.getUserName() + "'失败，手机号码已存在");
        }
        if (userService.updateUser(user) > 0)
        {
            return AjaxResult.success();
        }
        return AjaxResult.error("修改个人信息异常，请联系管理员");
    }

    /**
     * 重置密码
     */
    @PutMapping("/updatePassword")
    public AjaxResult updatePwd(String oldPassword, String newPassword)
    {
        Integer userId = AcsSecurityUtils.getUserId();
        User user = userService.selectUserById(userId);
        String password = user.getPassword();
        String salt = user.getSalt();
        if (!AcsSecurityUtils.matchesPassword(oldPassword, password,salt))
        {
            return AjaxResult.error("修改密码失败，旧密码错误");
        }
        if (AcsSecurityUtils.matchesPassword(newPassword, password,salt))
        {
            return AjaxResult.error("新密码不能与旧密码相同");
        }
        if (userService.resetUserPassword(userId, AcsSecurityUtils.encryptPassword(newPassword,salt)) > 0)
        {
            return AjaxResult.success();
        }
        return AjaxResult.error("修改密码异常，请联系管理员");
    }

    /**
     * 头像上传
     */
    @PostMapping("/avatar")
    public AjaxResult avatar(@RequestParam("avatarFile") MultipartFile file) throws IOException
    {
        System.out.println(file.getSize());
        if (!file.isEmpty())
        {
            Integer userId = AcsSecurityUtils.getUserId();
            String avatar = FileUploadUtils.upload(AcsConfig.getAvatarPath(), file);
            if (userService.updateUserAvatar(userId, avatar) > 0)
            {
                AjaxResult ajax = AjaxResult.success();
                ajax.put("imgUrl", avatar);
                return ajax;
            }
        }
        return AjaxResult.error("上传图片异常，请联系管理员");
    }
}
