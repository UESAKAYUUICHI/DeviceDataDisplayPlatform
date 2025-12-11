package com.devicedatadisplayplatform.module.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.devicedatadisplayplatform.module.customer.domain.User;
import com.devicedatadisplayplatform.module.customer.mapper.UserMapper;
import com.devicedatadisplayplatform.module.customer.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    
    @Override
    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }
    
    /**
     * 分页查询用户
     */
    @Override
    public IPage<User> getUserPage(int current, int size) {
        IPage<User> page = new Page<>(current, size);
        return userMapper.selectPage(page, null);
    }
    
    /**
     * 根据ID获取用户
     */
    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectById(userId);
    }
    
    /**
     * 新增用户
     */
    @Override
    public boolean addUser(User user) {
        // 检查用户名是否已存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        if (userMapper.selectOne(queryWrapper) != null) {
            return false; // 用户名已存在
        } else {
            return userMapper.insert(user) > 0;
        }
    }
    
    /**
     * 更新用户
     */
    @Override
    public boolean updateUser(User user) {
        return userMapper.updateById(user) > 0;
    }
    
    /**
     * 删除用户
     */
    @Override
    public boolean deleteUser(Integer userId) {
        return userMapper.deleteById(userId) > 0;
    }
}