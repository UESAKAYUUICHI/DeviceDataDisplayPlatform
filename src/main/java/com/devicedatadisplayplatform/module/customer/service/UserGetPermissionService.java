package com.devicedatadisplayplatform.module.customer.service;


import com.devicedatadisplayplatform.module.customer.DTO.UserGetPermissionDTO;

/**
 * Author UESAKAYUUICHI
 * Message 用户查询项目和权限服务层
 * Time 2025/12/12
 */
public interface UserGetPermissionService {
    UserGetPermissionDTO getUserGetPermission(Integer userId);
}
