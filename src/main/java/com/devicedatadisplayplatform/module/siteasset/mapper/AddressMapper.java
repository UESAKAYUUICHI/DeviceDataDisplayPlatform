package com.devicedatadisplayplatform.module.siteasset.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.devicedatadisplayplatform.module.siteasset.domain.Address;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author 
 * Message 地址mapper
 * Time 2025/12/13
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {
    // 继承 BaseMapper 已经提供了常用的 CRUD 方法，包括分页查询
}