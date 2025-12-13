package com.devicedatadisplayplatform.module.customer.form;



import lombok.Data;

import java.util.Date;

/**
 * Author UESAKAYUUICHI
 * Message 用户表单类
 * Time 2025/12/12
 */
@Data
public class UserForm {

    private Integer userId;
    private String username;
    private String passwordHash;
    private String email;
    private Date createdAt;
    private Date updatedAt;
}
