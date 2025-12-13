package com.devicedatadisplayplatform.module.siteasset.VO;

import lombok.Data;

/**
 * Author 
 * Message 产品前端返回类
 * Time 2025/12/13
 */
@Data
public class ProductVO {
    private Long productId;
    private Integer deviceType;
    private String productName;
    private Integer platformType;
    private Integer nodeType;
}