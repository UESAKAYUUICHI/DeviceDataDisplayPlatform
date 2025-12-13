package com.devicedatadisplayplatform.module.siteasset.form;

import lombok.Data;
import java.util.Date;

/**
 * Author 
 * Message 产品前端表单类
 * Time 2025/12/13
 */
@Data
public class ProductForm {
    private Long productId;
    private Integer deviceType;
    private String productName;
    private Integer platformType;
    private Integer nodeType;
    private Integer orderNum;
    private Long createUserId;
    private Date createTime;
}