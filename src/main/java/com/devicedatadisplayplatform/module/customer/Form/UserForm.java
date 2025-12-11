package com.devicedatadisplayplatform.module.customer.Form;



import lombok.Data;

import java.util.Date;

@Data
public class UserForm {

    private Integer userId;
    private String username;
    private String passwordHash;
    private String email;
    private Date createdAt;
    private Date updatedAt;
}
