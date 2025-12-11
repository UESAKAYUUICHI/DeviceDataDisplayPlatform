package com.devicedatadisplayplatform.module.customer.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.devicedatadisplayplatform.module.customer.domain.Permission;

import java.util.List;

public interface PermissionService {
    /**
     * 获取所有权限
     */
    List<Permission> getAllPermissions();
    
    /**
     * 分页查询权限
     */
    IPage<Permission> getPermissionPage(int current, int size);
    
    /**
     * 根据ID获取权限
     */
    Permission getPermissionById(Integer permId);
    
    /**
     * 新增权限
     */
    boolean addPermission(Permission permission);
    
    /**
     * 更新权限
     */
    boolean updatePermission(Permission permission);
    
    /**
     * 删除权限
     */
    boolean deletePermission(Integer permId);
}