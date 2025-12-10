package com.devicedatadisplayplatform.module.customer.vo;

import lombok.Data;

import java.util.List;

@Data
public class UserContextVO {
    private List<ProjectVO> projects;
    private List<String> permissions; // 权限编码列表，如 ["device:read", "alert:resolve"]
}