package com.devicedatadisplayplatform.module.customer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.devicedatadisplayplatform.common.result.Result;
import com.devicedatadisplayplatform.common.util.ConvertUtil;
import com.devicedatadisplayplatform.module.customer.Form.PermissionForm;
import com.devicedatadisplayplatform.module.customer.domain.Permission;
import com.devicedatadisplayplatform.module.customer.service.PermissionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    
    @Resource
    private PermissionService permissionService;
    
    /**
     * 获取所有权限
     */
    @GetMapping("/listPermission")
    public Result<List<Permission>> getAllPermissions() {
        List<Permission> permissions = permissionService.getAllPermissions();
        return Result.ok(permissions);
    }
    
    /**
     * 分页获取权限
     */
    @GetMapping("/pagePermission")
    public Result<IPage<Permission>> getPermissionPage(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "10") int size) {
        IPage<Permission> page = permissionService.getPermissionPage(current, size);
        return Result.ok(page);
    }
    
    /**
     * 根据ID获取权限
     */
    @GetMapping("/getPermission")
    public Result<Permission> getPermissionById(@RequestParam Integer permId) {
        Permission permission = permissionService.getPermissionById(permId);
        return Result.ok(permission);
    }
    
    /**
     * 新增权限
     */
    @PostMapping("/addPermission")
    public Result<String> addPermission(@RequestBody PermissionForm permissionForm) {
        Permission permission = ConvertUtil.convert(permissionForm, Permission.class);
        boolean success = permissionService.addPermission(permission);
        if (success) {
            return Result.ok("权限新增成功");
        } else {
            return Result.fail("权限新增失败，权限码可能已存在");
        }
    }
    
    /**
     * 更新权限
     */
    @PostMapping("/updatePermission")
    public Result<String> updatePermission(@RequestBody PermissionForm permissionForm) {
        Permission permission = ConvertUtil.convert(permissionForm, Permission.class);
        boolean success = permissionService.updatePermission(permission);
        if (success) {
            return Result.ok("权限更新成功");
        } else {
            return Result.fail("权限更新失败");
        }
    }
    
    /**
     * 删除权限
     */
    @GetMapping("/deletePermission")
    public Result<String> deletePermission(@RequestParam Integer permId) {
        boolean success = permissionService.deletePermission(permId);
        if (success) {
            return Result.ok("权限删除成功");
        } else {
            return Result.fail("权限删除失败");
        }
    }
}