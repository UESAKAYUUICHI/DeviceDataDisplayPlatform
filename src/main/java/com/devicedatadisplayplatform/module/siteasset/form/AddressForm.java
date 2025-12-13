package com.devicedatadisplayplatform.module.siteasset.form;

import lombok.Data;
import java.util.Date;

/**
 * Author 
 * Message 地址前端表单类
 * Time 2025/12/13
 */
@Data
public class AddressForm {
    private Long addressId;
    private Integer addressType;
    private String addressName;
    private Long projectId;
    private String parentAddressId;
    private Integer sort;
    private String baseAddressId;
    private Integer delFlag;
    private String addressTree;
    private String modelConfig;
    private String area;
    private Date createTime;
    private Date updateTime;
}