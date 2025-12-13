package com.devicedatadisplayplatform.module.siteasset.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.devicedatadisplayplatform.module.siteasset.domain.Address;

import java.util.List;

/**
 * Author 
 * Message 地址服务层
 * Time 2025/12/13
 */
public interface AddressService {

    /*
    *  获取所有地址
    * */
    List<Address> getAllAddresses();

    /*
     *  分页查询地址
     * */
    IPage<Address> getAddressPage(int current, int size);
    
    /*
     *  根据ID获取地址
     * */
    Address getAddressById(Long addressId);

    /*
     *  新增地址
     * */
    boolean addAddress(Address address);

    /*
     *  更新地址
     * */
    boolean updateAddress(Address address);

    /*
     *  删除地址
     * */
    Boolean deleteAddress(Long addressId);
}