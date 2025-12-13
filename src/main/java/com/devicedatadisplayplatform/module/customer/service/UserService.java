package com.devicedatadisplayplatform.module.customer.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.devicedatadisplayplatform.module.customer.domain.User;

import java.util.List;

/**
 * Author UESAKAYUUICHI
 * Message 用户类服务层
 * Time 2025/12/12
 */
public interface UserService {
    List<User> getAllUsers();
    
    /**
     * 分页查询用户
     */
    IPage<User> getUserPage(int current, int size);
    
    /**
     * 根据ID获取用户
     */
    User getUserById(Integer userId);
    
    /**
     * 新增用户
     */
    boolean addUser(User user);
    
    /**
     * 更新用户
     */
    boolean updateUser(User user);
    
    /**
     * 删除用户
     */
    boolean deleteUser(Integer userId);
    
//    UserContextVO getUserContext(Integer userId);
}