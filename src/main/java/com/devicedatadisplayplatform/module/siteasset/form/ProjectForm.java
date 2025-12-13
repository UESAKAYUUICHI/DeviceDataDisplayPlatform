package com.devicedatadisplayplatform.module.siteasset.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Author UESAKAYUUICHI
 * Message 项目前端表单类
 * Time 2025/12/13
 */
@Data
public class ProjectForm {
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