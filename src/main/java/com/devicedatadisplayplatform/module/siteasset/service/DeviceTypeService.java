package com.devicedatadisplayplatform.module.siteasset.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.devicedatadisplayplatform.module.siteasset.domain.DeviceType;

import java.util.List;

/**
 * Author 
 * Message 设备类型服务层
 * Time 2025/12/13
 */
public interface DeviceTypeService {

    /*
    *  获取所有设备类型
    * */
    List<DeviceType> getAllDeviceTypes();

    /*
     *  分页查询设备类型
     * */
    IPage<DeviceType> getDeviceTypePage(int current, int size);
    
    /*
     *  根据ID获取设备类型
     * */
    DeviceType getDeviceTypeById(Integer deviceTypeId);

    /*
     *  新增设备类型
     * */
    boolean addDeviceType(DeviceType deviceType);

    /*
     *  更新设备类型
     * */
    boolean updateDeviceType(DeviceType deviceType);

    /*
     *  删除设备类型
     * */
    Boolean deleteDeviceType(Integer deviceTypeId);
}