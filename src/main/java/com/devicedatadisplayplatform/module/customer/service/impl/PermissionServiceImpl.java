package com.devicedatadisplayplatform.module.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.devicedatadisplayplatform.module.customer.domain.Permission;
import com.devicedatadisplayplatform.module.customer.mapper.PermissionMapper;
import com.devicedatadisplayplatform.module.customer.service.PermissionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author UESAKAYUUICHI
 * Message 权限服务层实现类
 * Time 2025/12/12
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    
    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 获取所有权限
     */
    @Override
    public List<Permission> getAllPermissions() {
        return permissionMapper.selectList(null);
    }

    /**
     * 分页查询权限
     */
    @Override
    public IPage<Permission> getPermissionPage(int current, int size) {
        IPage<Permission> page = new Page<>(current, size);
        return permissionMapper.selectPage(page, null);
    }
    
    /**
     * 根据ID获取权限
     */
    @Override
    public Permission getPermissionById(Integer permId) {
        return permissionMapper.selectById(permId);
    }
    
    /**
     * 新增权限
     */
    @Override
    public boolean addPermission(Permission permission) {
        // 检查权限码是否已存在
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("perm_code", permission.getPermCode());
        if (permissionMapper.selectOne(queryWrapper) != null) {
            return false; // 权限码已存在
        } else {
            return permissionMapper.insert(permission) > 0;
        }
    }
    
    /**
     * 更新权限
     */
    @Override
    public boolean updatePermission(Permission permission) {
        return permissionMapper.updateById(permission) > 0;
    }
    
    /**
     * 删除权限
     */
    @Override
    public boolean deletePermission(Integer permId) {
        return permissionMapper.deleteById(permId) > 0;
    }
}