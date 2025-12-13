package com.devicedatadisplayplatform.module.siteasset.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.devicedatadisplayplatform.module.siteasset.domain.DeviceType;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author 
 * Message 设备类型mapper
 * Time 2025/12/13
 */
@Mapper
public interface DeviceTypeMapper extends BaseMapper<DeviceType> {
    // 继承 BaseMapper 已经提供了常用的 CRUD 方法，包括分页查询
}