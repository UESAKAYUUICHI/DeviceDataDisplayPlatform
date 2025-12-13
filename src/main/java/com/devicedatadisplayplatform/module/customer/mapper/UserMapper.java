package com.devicedatadisplayplatform.module.customer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.devicedatadisplayplatform.module.customer.domain.Permission;
import com.devicedatadisplayplatform.module.siteasset.domain.Project;
import com.devicedatadisplayplatform.module.customer.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author UESAKAYUUICHI
 * Message 用户mapper
 * Time 2025/12/12
 */
public interface UserMapper extends BaseMapper<User> {
    // 查询用户关联的项目列表 (通过 t_user_project 关联 t_project)
    @Select({
            "SELECT p.project_id, p.project_name, p.dept_id, p.address, p.manager, p.phone, ",
            "       p.project_type, p.protocol_type, p.owner, p.line_num, p.capacity, p.status, ",
            "       p.power, p.project_mold, p.energy_day, p.energy_month, p.energy_year, p.province, ",
            "       p.del_flag, p.password, p.photo, p.start_running_date, p.create_time, p.update_time ",
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