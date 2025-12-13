package com.devicedatadisplayplatform.module.customer.service.impl;

import com.devicedatadisplayplatform.module.customer.DTO.UserGetPermissionDTO;
import com.devicedatadisplayplatform.module.customer.domain.Permission;
import com.devicedatadisplayplatform.module.customer.domain.User;
import com.devicedatadisplayplatform.module.siteasset.domain.Project;
import com.devicedatadisplayplatform.module.customer.mapper.UserMapper;
import com.devicedatadisplayplatform.module.customer.service.UserGetPermissionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserGetPermissionServiceImpl implements UserGetPermissionService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserGetPermissionDTO getUserGetPermission(Integer userId) {
        // 1. 获取用户基本信息 (仅需 username)
        User user = userMapper.selectById(userId);
        if (user == null) {
            throw new IllegalArgumentException("用户不存在");
        }

        // 2. 查询关联项目
        List<Project> projects = userMapper.selectProjectsByUserId(userId);

        // 3. 查询关联权限
        List<Permission> permissions = userMapper.selectPermissionsByUserId(userId);

        // 4. 转换为 DTO 格式
        UserGetPermissionDTO dto = new UserGetPermissionDTO();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());

        // 项目转换
        dto.setProjects(projects.stream()
                .map(p -> {
                    UserGetPermissionDTO.ProjectDTO item = new UserGetPermissionDTO.ProjectDTO();
                    item.setProjectId(p.getProjectId());
                    item.setProjectName(p.getProjectName());
                    item.setDeptId(p.getDeptId());
                    item.setAddress(p.getAddress());
                    item.setManager(p.getManager());
                    item.setPhone(p.getPhone());
                    item.setProjectType(p.getProjectType());
                    item.setProtocolType(p.getProtocolType());
                    item.setOwner(p.getOwner());
                    item.setLineNum(p.getLineNum());
                    item.setCapacity(p.getCapacity());
                    item.setStatus(p.getStatus());
                    item.setPower(p.getPower());
                    item.setProjectMold(p.getProjectMold());
                    item.setEnergyDay(p.getEnergyDay());
                    item.setEnergyMonth(p.getEnergyMonth());
                    item.setEnergyYear(p.getEnergyYear());
                    item.setProvince(p.getProvince());
                    item.setDelFlag(p.getDelFlag());
                    item.setPassword(p.getPassword());
                    item.setPhoto(p.getPhoto());
                    item.setStartRunningDate(p.getStartRunningDate());
                    item.setCreateTime(p.getCreateTime());
                    item.setUpdateTime(p.getUpdateTime());
                    return item;
                })
                .collect(Collectors.toList()));

        // 权限转换
        dto.setPermissions(permissions.stream()
                .map(p -> {
                    UserGetPermissionDTO.PermissionDTO item = new UserGetPermissionDTO.PermissionDTO();
                    item.setPermId(p.getPermId());
                    item.setPermCode(p.getPermCode());
                    item.setPermName(p.getPermName());
                    item.setModule(p.getModule());
                    return item;
                })
                .collect(Collectors.toList()));

        return dto;
    }


}
