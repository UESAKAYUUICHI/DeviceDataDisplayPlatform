package com.devicedatadisplayplatform.module.customer.form;

import lombok.Data;

/**
 * Author UESAKAYUUICHI
 * Message 权限表单类
 * Time 2025/12/12
 */
@Data
public class PermissionForm {
    private Integer permId;
    private String permCode;   // 如 "device:read"
    private String permName;   // 如 "设备查看"
    private String module;
}
