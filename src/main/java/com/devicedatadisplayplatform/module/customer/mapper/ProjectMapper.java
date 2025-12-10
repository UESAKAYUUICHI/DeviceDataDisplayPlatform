package com.devicedatadisplayplatform.module.customer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.devicedatadisplayplatform.module.customer.domain.Project;
import com.devicedatadisplayplatform.module.customer.vo.ProjectVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProjectMapper extends BaseMapper<Project> {
    @Select("SELECT p.project_id, p.project_name, p.status " +
            "FROM t_user_project up " +
            "JOIN t_project p ON up.project_id = p.project_id " +
            "WHERE up.user_id = #{userId}")
    List<ProjectVO> selectProjectsByUserId(@Param("userId") Integer userId);
}