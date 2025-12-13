package com.devicedatadisplayplatform.module.siteasset.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.devicedatadisplayplatform.common.result.Result;
import com.devicedatadisplayplatform.common.util.ConvertUtil;
import com.devicedatadisplayplatform.module.siteasset.form.DeviceTypeForm;
import com.devicedatadisplayplatform.module.siteasset.domain.DeviceType;
import com.devicedatadisplayplatform.module.siteasset.service.DeviceTypeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author 
 * Message 设备类型控制器
 * Time 2025/12/13
 */
@RestController
@RequestMapping("/deviceType")
public class DeviceTypeController {

    @Resource
    private DeviceTypeService deviceTypeService;

    @GetMapping("/listDeviceType")
    public Result<List<DeviceType>> getAllDeviceTypes() {
        List<DeviceType> deviceTypes = deviceTypeService.getAllDeviceTypes();
        return Result.ok(deviceTypes);
    }

    @GetMapping("/pageDeviceType")
    public Result<IPage<DeviceType>> getDeviceTypePage(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "10") int size) {
        IPage<DeviceType> page = deviceTypeService.getDeviceTypePage(current, size);
        return Result.ok(page);
    }
    
    @GetMapping("/getDeviceType")
    public Result<DeviceType> getDeviceTypeById(@RequestParam Integer deviceTypeId) {
        DeviceType deviceType = deviceTypeService.getDeviceTypeById(deviceTypeId);
        return Result.ok(deviceType);
    }

    @PostMapping("/addDeviceType")
    public Result<String> addDeviceType(@RequestBody DeviceTypeForm deviceTypeForm) {
        DeviceType deviceType = ConvertUtil.convert(deviceTypeForm, DeviceType.class);
        boolean success = deviceTypeService.addDeviceType(deviceType);
        if (success) {
            return Result.ok("设备类型新增成功");
        } else {
            return Result.fail("设备类型新增失败");
        }
    }

    @PostMapping("/updateDeviceType")
    public Result<String> updateDeviceType(@RequestBody DeviceTypeForm deviceTypeForm) {
        DeviceType deviceType = ConvertUtil.convert(deviceTypeForm, DeviceType.class);
        boolean success = deviceTypeService.updateDeviceType(deviceType);
        if (success) {
            return Result.ok("设备类型更新成功");
        } else {
            return Result.fail("设备类型更新失败");
        }
    }

    @GetMapping("/deleteDeviceType")
    public Result<String> deleteDeviceType(@RequestParam Integer deviceTypeId) {
        boolean success = deviceTypeService.deleteDeviceType(deviceTypeId);
        if (success) {
            return Result.ok("设备类型删除成功");
        } else {
            return Result.fail("设备类型删除失败");
        }
    }
}