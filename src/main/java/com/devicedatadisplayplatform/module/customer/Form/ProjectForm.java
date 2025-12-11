package com.devicedatadisplayplatform.module.customer.Form;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectForm {
    private Integer projectId;
    private String projectName;
    private String mainDeviceId;
    private String status; // active / completed
    private Date createdAt;
    private Date updatedAt;
}