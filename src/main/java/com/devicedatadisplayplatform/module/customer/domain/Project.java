package com.devicedatadisplayplatform.module.customer.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_project")
public class Project {
    @TableId(value = "project_id", type = IdType.AUTO)
    private Integer projectId;
    @TableField("project_name")
    private String projectName;
    @TableField("main_device_id")
    private String mainDeviceId;
    @TableField("status")
    private String status; // active / completed
    @TableField("created_at")
    private Date createdAt;
    @TableField("updated_at")
    private Date updatedAt;
}