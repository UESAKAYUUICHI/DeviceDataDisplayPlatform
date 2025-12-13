package com.devicedatadisplayplatform.module.siteasset.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

/**
 * Author UESAKAYUUICHI
 * Message 地址信息实体类
 * Time 2025/12/13
 */
@Data
@TableName("t_address")
public class Address {
    // 地址ID（主键，字符串类型）
    @TableId(value = "address_id", type = IdType.INPUT)
    private Long addressId;

    // 地址类型（1=房间，2=机柜）
    @TableField("address_type")
    private Integer addressType;

    // 地址名称（如机房A）
    @TableField("address_name")
    private String addressName;

    // 项目ID（关联 t_project.project_id）
    @TableField("project_id")
    private Long projectId;

    // 父地址ID（用于树形结构，关联自身 address_id）
    @TableField("parent_address_id")
    private String parentAddressId;

    // 排序值（界面展示顺序）
    @TableField("sort")
    private Integer sort;

    // 基础地址ID（关联自身 address_id）
    @TableField("base_address_id")
    private String baseAddressId;

    // 删除标识：0=正常，1=删除
    @TableField("del_flag")
    private Integer delFlag;

    // 地址树（存储路径，如1/2/3）
    @TableField("address_tree")
    private String addressTree;

    // 模型配置（存储字符串）
    @TableField("model_config")
    private String modelConfig;

    // 面积（单位平方米，存储字符串）
    @TableField("area")
    private String area;

    // 创建时间
    @TableField("create_time")
    private Date createTime;

    // 最后更新时间
    @TableField("update_time")
    private Date updateTime;
}