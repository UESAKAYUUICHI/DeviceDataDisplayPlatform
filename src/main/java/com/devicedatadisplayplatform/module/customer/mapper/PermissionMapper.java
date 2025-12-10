package com.devicedatadisplayplatform.module.customer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.devicedatadisplayplatform.module.customer.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
    @Select("SELECT p.perm_code " +
            "FROM t_user_permission up " +
            "JOIN t_permission p ON up.perm_id = p.perm_id " +
            "WHERE up.user_id = #{userId}")
    List<String> selectPermissionCodesByUserId(@Param("userId") Integer userId);
}