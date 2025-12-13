package com.devicedatadisplayplatform.module.siteasset.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Author UESAKAYUUICHI
 * Message 设备类型实体类
 * Time 2025/12/13
 */
@Data
@TableName("t_device_type")
public class DeviceType {
    // 设备类型ID（主键，数据库自增）
    @TableId(value = "device_type_id", type = IdType.AUTO)
    private Integer deviceTypeId;

    // 类型名称（如光伏逆变器）
    @TableField("type_name")
    private String typeName;

    // 类型描述（可选）
    @TableField("description")
    private String description;
}