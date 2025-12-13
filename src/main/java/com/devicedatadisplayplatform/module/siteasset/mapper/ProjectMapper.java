package com.devicedatadisplayplatform.module.siteasset.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.devicedatadisplayplatform.module.siteasset.domain.Project;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectMapper extends BaseMapper<Project> {
    // 继承 BaseMapper 已经提供了常用的 CRUD 方法，包括分页查询
}