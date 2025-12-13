package com.devicedatadisplayplatform.module.siteasset.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.devicedatadisplayplatform.module.siteasset.domain.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * Author 
 * Message 产品mapper
 * Time 2025/12/13
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
    // 继承 BaseMapper 已经提供了常用的 CRUD 方法，包括分页查询
}