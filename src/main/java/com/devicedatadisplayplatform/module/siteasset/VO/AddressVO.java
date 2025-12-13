package com.devicedatadisplayplatform.module.siteasset.VO;

import lombok.Data;

/**
 * Author 
 * Message 地址前端返回类
 * Time 2025/12/13
 */
@Data
public class AddressVO {
    private Long addressId;
    private Integer addressType;
    private String addressName;
    private Long projectId;
    private String parentAddressId;
}