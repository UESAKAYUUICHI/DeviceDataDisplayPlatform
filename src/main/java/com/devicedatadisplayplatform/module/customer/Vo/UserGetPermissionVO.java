package com.devicedatadisplayplatform.module.customer.Vo;

import com.devicedatadisplayplatform.module.customer.DTO.UserGetPermissionDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Author UESAKAYUUICHI
 * Message 用户查询权限和项目 前端返回类
 * Time 2025/12/12
 */
@Data
public class UserGetPermissionVO {
    private Integer userId;
    private String username;
    private List<UserGetPermissionDTO.ProjectDTO> projects; // 关联项目列表
    private List<UserGetPermissionDTO.PermissionDTO> permissions; // 关联权限列表

    @Data
    public static class ProjectDTO {
        private Integer projectId;  // 修改为String类型
        private String projectName;
        private String address;
        private String status;
        private String manager;
        private Date createdAt;
        private Date updatedAt;
    }

    @Data
    public static class PermissionDTO {
        private Integer permId;
        private String permCode;
        private String permName;
        private String module;
    }
}