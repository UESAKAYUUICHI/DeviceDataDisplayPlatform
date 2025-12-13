package com.devicedatadisplayplatform.module.customer.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Author UESAKAYUUICHI
 * Message 用户实体类
 * Time 2025/12/12
 */
@Data
@TableName("t_user")
public class User {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    @TableField("username")
    private String username;
    @TableField("password_hash")
    private String passwordHash;
    @TableField("email")
    private String email;
    @TableField("created_at")
    private Date createdAt;
    @TableField("updated_at")
    private Date updatedAt;
}