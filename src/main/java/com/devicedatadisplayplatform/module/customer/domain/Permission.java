package com.devicedatadisplayplatform.module.customer.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * Author UESAKAYUUICHI
 * Message 权限实体类
 * Time 2025/12/12
 */
@Data
@TableName("t_permission")
public class Permission {
    @TableId(value = "perm_id", type = IdType.AUTO)
    private Integer permId;
    @TableField("perm_code")
    private String permCode;   // 如 "device:read"
    @TableField("perm_name")
    private String permName;   // 如 "设备查看"
    @TableField("module")
    private String module;     // 如 "device"
}