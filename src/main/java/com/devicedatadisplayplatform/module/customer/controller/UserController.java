package com.devicedatadisplayplatform.module.customer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.devicedatadisplayplatform.common.result.Result;
import com.devicedatadisplayplatform.common.util.ConvertUtil;
import com.devicedatadisplayplatform.module.customer.DTO.UserGetPermissionDTO;
import com.devicedatadisplayplatform.module.customer.form.UserForm;
import com.devicedatadisplayplatform.module.customer.domain.User;
import com.devicedatadisplayplatform.module.customer.service.UserGetPermissionService;
import com.devicedatadisplayplatform.module.customer.service.UserService;
import com.devicedatadisplayplatform.module.customer.Vo.UserGetPermissionVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserGetPermissionService userGetPermissionService;
    
    @GetMapping("/listUser")
    public Result<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return Result.ok(users);
    }
    
    @GetMapping("/pageUser")
    public Result<IPage<User>> getUserPage(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "10") int size) {
        IPage<User> page = userService.getUserPage(current, size);
        return Result.ok(page);
    }
    
    @GetMapping("/getUser")
    public Result<User> getUserById(@RequestParam Integer userId) {
        User user = userService.getUserById(userId);
        return Result.ok(user);
    }
    
    @PostMapping("/addUser")
    public Result<String> addUser(@RequestBody UserForm userForm) {
        User user = ConvertUtil.convert(userForm, User.class);
        boolean success = userService.addUser(user);
        if (success) {
            return Result.ok("用户新增成功");
        } else {
            return Result.fail("用户新增失败，用户名可能已存在");
        }
    }
    
    @PostMapping("/updateUser")
    public Result<String> updateUser(@RequestBody UserForm userForm) {
        User user = ConvertUtil.convert(userForm, User.class);
        boolean success = userService.updateUser(user);
        if (success) {
            return Result.ok("用户更新成功");
        } else {
            return Result.fail("用户更新失败");
        }
    }
    
    @GetMapping("/deleteUser")
    public Result<String> deleteUser(@RequestParam Integer userId) {
        boolean success = userService.deleteUser(userId);
        if (success) {
            return Result.ok("用户删除成功");
        } else {
            return Result.fail("用户删除失败");
        }
    }

        @GetMapping("/getUserGetPermission")
    public Result<UserGetPermissionVO> getUserGetPermission(@RequestParam Integer userId) {
        //获取dto
        UserGetPermissionDTO dto = userGetPermissionService.getUserGetPermission(userId);
        //dto转化为vo,用了我的自定义工具类转化了一下
        UserGetPermissionVO vo = ConvertUtil.convertIgnoreExtraFields(dto, UserGetPermissionVO.class);
        //返回vo
        return Result.ok(vo);
    }
}