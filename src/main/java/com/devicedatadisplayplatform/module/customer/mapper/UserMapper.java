package com.devicedatadisplayplatform.module.customer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.devicedatadisplayplatform.module.customer.domain.Permission;
import com.devicedatadisplayplatform.module.customer.domain.Project;
import com.devicedatadisplayplatform.module.customer.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 查询用户关联的项目列表 (通过 t_user_project 关联 t_project)
    @Select({
            "SELECT p.project_id, p.project_name, p.status ",
            "FROM t_project p ",
            "JOIN t_user_project up ON p.project_id = up.project_id ",
            "WHERE up.user_id = #{userId}"
    })
    List<Project> selectProjectsByUserId(Integer userId);

    // 查询用户关联的权限列表 (通过 t_user_permission 关联 t_permission)
    @Select({
            "SELECT perm.perm_id, perm.perm_code, perm.perm_name, perm.module ",
            "FROM t_permission perm ",
            "JOIN t_user_permission up ON perm.perm_id = up.perm_id ",
            "WHERE up.user_id = #{userId}"
    })
    List<Permission> selectPermissionsByUserId(Integer userId);
}