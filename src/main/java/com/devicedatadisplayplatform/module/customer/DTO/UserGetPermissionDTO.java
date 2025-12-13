package com.devicedatadisplayplatform.module.customer.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Author UESAKAYUUICHI
 * Message 通过用户联级查询 权限 和 关联项目 实体类
 * Time 2025/12/12
 */
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
        private Long deptId;
        private String address;
        private String manager;
        private String phone;
        private Integer projectType;
        private Integer protocolType;
        private String owner;
        private Integer lineNum;
        private BigDecimal capacity;
        private Integer status;
        private BigDecimal power;
        private String projectMold;
        private BigDecimal energyDay;
        private BigDecimal energyMonth;
        private BigDecimal energyYear;
        private String province;
        private Integer delFlag;
        private String password;
        private String photo;
        private Date startRunningDate;
        private Date createTime;
        private Date updateTime;
    }

    @Data
    public static class PermissionDTO {
        private Integer permId;
        private String permCode;
        private String permName;
        private String module;
    }
}