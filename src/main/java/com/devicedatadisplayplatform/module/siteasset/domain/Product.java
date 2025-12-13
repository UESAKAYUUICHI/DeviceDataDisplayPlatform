package com.devicedatadisplayplatform.module.siteasset.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

/**
 * Author UESAKAYUUICHI
 * Message 产品信息实体类
 * Time 2025/12/13
 */
@Data
@TableName("t_product")
public class Product {
    // 产品ID（主键，格式：PROD_2001）
    @TableId(value = "product_id", type = IdType.INPUT)
    private Long productId;

    // 所属设备类型（关联 t_device_type.device_type_id）
    @TableField("device_type")
    private Integer deviceType;

    // 产品名称（如"光伏逆变器标准版"）
    @TableField("product_name")
    private String productName;

    // 平台类型（1=云平台，2=本地平台）
    @TableField("platform_type")
    private Integer platformType;

    // 节点类型：0=网关, 1=子设备
    @TableField("node_type")
    private Integer nodeType;

    // 排序值（数值越大越靠前）
    @TableField("order_num")
    private Integer orderNum;

    // 创建用户ID
    @TableField("create_user_id")
    private Long createUserId;

    // 创建时间
    @TableField("create_time")
    private Date createTime;
}