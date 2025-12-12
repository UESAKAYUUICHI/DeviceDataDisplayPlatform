package com.devicedatadisplayplatform.module.customer.vo;

import com.devicedatadisplayplatform.module.customer.DTO.UserGetPermissionDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserGetPermissionVO {
    private Integer userId;
    private String username;
    private List<UserGetPermissionDTO.ProjectDTO> projects; // 关联项目列表
    private List<UserGetPermissionDTO.PermissionDTO> permissions; // 关联权限列表

    @Data
    public static class ProjectDTO {
        private Integer projectId;
        private String projectName;
        private String mainDeviceId;
        private String status;
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