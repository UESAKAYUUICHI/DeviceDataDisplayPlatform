package com.devicedatadisplayplatform.module.customer.Form;

import lombok.Data;

@Data
public class PermissionForm {
    private Integer permId;
    private String permCode;   // 如 "device:read"
    private String permName;   // 如 "设备查看"
    private String module;
}
