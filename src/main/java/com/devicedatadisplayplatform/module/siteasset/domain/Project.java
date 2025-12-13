package com.devicedatadisplayplatform.module.siteasset.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Author UESAKAYUUICHI
 * Message 项目实体类
 * Time 2025/12/13
 */
@Data
@TableName("t_project")
public class Project {
    @TableId(value = "project_id", type = IdType.AUTO)
    private Integer projectId;
    
    @TableField("project_name")
    private String projectName;
    
    @TableField("dept_id")
    private Long deptId;
    
    @TableField("address")
    private String address;
    
    @TableField("manager")
    private String manager;
    
    @TableField("phone")
    private String phone;
    
    @TableField("project_type")
    private Integer projectType;
    
    @TableField("protocol_type")
    private Integer protocolType;
    
    @TableField("owner")
    private String owner;
    
    @TableField("line_num")
    private Integer lineNum;
    
    @TableField("capacity")
    private BigDecimal capacity;
    
    @TableField("status")
    private Integer status;
    
    @TableField("power")
    private BigDecimal power;
    
    @TableField("project_mold")
    private String projectMold;
    
    @TableField("energy_day")
    private BigDecimal energyDay;
    
    @TableField("energy_month")
    private BigDecimal energyMonth;
    
    @TableField("energy_year")
    private BigDecimal energyYear;
    
    @TableField("province")
    private String province;
    
    @TableField("del_flag")
    private Integer delFlag;
    
    @TableField("password")
    private String password;
    
    @TableField("photo")
    private String photo;
    
    @TableField("start_running_date")
    private Date startRunningDate;
    
    @TableField("create_time")
    private Date createTime;
    
    @TableField("update_time")
    private Date updateTime;
}