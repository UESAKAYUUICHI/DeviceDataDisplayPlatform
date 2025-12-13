package com.devicedatadisplayplatform.module.siteasset.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.devicedatadisplayplatform.common.result.Result;
import com.devicedatadisplayplatform.common.util.ConvertUtil;
import com.devicedatadisplayplatform.module.siteasset.form.AddressForm;
import com.devicedatadisplayplatform.module.siteasset.domain.Address;
import com.devicedatadisplayplatform.module.siteasset.service.AddressService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author 
 * Message 地址控制器
 * Time 2025/12/13
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Resource
    private AddressService addressService;

    @GetMapping("/listAddress")
    public Result<List<Address>> getAllAddresses() {
        List<Address> addresses = addressService.getAllAddresses();
        return Result.ok(addresses);
    }

    @GetMapping("/pageAddress")
    public Result<IPage<Address>> getAddressPage(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "10") int size) {
        IPage<Address> page = addressService.getAddressPage(current, size);
        return Result.ok(page);
    }
    
    @GetMapping("/getAddress")
    public Result<Address> getAddressById(@RequestParam Long addressId) {
        Address address = addressService.getAddressById(addressId);
        return Result.ok(address);
    }

    @PostMapping("/addAddress")
    public Result<String> addAddress(@RequestBody AddressForm addressForm) {
        Address address = ConvertUtil.convert(addressForm, Address.class);
        boolean success = addressService.addAddress(address);
        if (success) {
            return Result.ok("地址新增成功");
        } else {
            return Result.fail("地址新增失败");
        }
    }

    @PostMapping("/updateAddress")
    public Result<String> updateAddress(@RequestBody AddressForm addressForm) {
        Address address = ConvertUtil.convert(addressForm, Address.class);
        boolean success = addressService.updateAddress(address);
        if (success) {
            return Result.ok("地址更新成功");
        } else {
            return Result.fail("地址更新失败");
        }
    }

    @GetMapping("/deleteAddress")
    public Result<String> deleteAddress(@RequestParam Long addressId) {
        boolean success = addressService.deleteAddress(addressId);
        if (success) {
            return Result.ok("地址删除成功");
        } else {
            return Result.fail("地址删除失败");
        }
    }
}