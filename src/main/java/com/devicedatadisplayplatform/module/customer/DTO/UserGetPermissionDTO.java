package com.devicedatadisplayplatform.module.customer.DTO;

import lombok.Data;

import java.util.List;

@Data
public class UserGetPermissionDTO {
    private Integer userId;
    private String username;
    private List<ProjectDTO> projects; // 关联项目列表
    private List<PermissionDTO> permissions; // 关联权限列表

    @Data
    public static class ProjectDTO {
        private Integer projectId;
        private String projectName;
        private String status;
    }

    @Data
    public static class PermissionDTO {
        private Integer permId;
        private String permCode;
        private String permName;
        private String module;
    }
}
