package com.devicedatadisplayplatform.module.siteasset.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.devicedatadisplayplatform.module.siteasset.domain.DeviceType;
import com.devicedatadisplayplatform.module.siteasset.mapper.DeviceTypeMapper;
import com.devicedatadisplayplatform.module.siteasset.service.DeviceTypeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author 
 * Message 设备类型服务层实现类
 * Time 2025/12/13
 */
@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {

    @Resource
    private DeviceTypeMapper deviceTypeMapper;

    /*
    *  获取所有设备类型
    * */
    @Override
    public List<DeviceType> getAllDeviceTypes() {
        return deviceTypeMapper.selectList(null);
    }

    /*
     *  分页获取设备类型
     * */
    @Override
    public IPage<DeviceType> getDeviceTypePage(int current, int size) {
        IPage<DeviceType> page = new Page<>(current, size);
        return deviceTypeMapper.selectPage(page, null);
    }
    
    /*
     *  根据ID获取设备类型
     * */
    @Override
    public DeviceType getDeviceTypeById(Integer deviceTypeId) {
        return deviceTypeMapper.selectById(deviceTypeId);
    }
    
    /*
     *  新增设备类型
     * */
    @Override
    public boolean addDeviceType(DeviceType deviceType){
        // 使用 QueryWrapper 查询设备类型是否已存在
        QueryWrapper<DeviceType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type_name", deviceType.getTypeName());
        if(deviceTypeMapper.selectOne(queryWrapper) != null){
            return false;
        }else{
            deviceTypeMapper.insert(deviceType);
            return true;
        }
    }

    /*
     *  更新设备类型
     * */
    @Override
    public boolean updateDeviceType(DeviceType deviceType){
        // 应该返回更新影响的行数是否大于0
        return deviceTypeMapper.updateById(deviceType) > 0;
    }

    /*
     *  删除设备类型
     * */
    @Override
    public Boolean deleteDeviceType(Integer deviceTypeId){
        return deviceTypeMapper.deleteById(deviceTypeId) > 0;
    }
}