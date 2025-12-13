package com.devicedatadisplayplatform.module.siteasset.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.devicedatadisplayplatform.module.siteasset.domain.Address;
import com.devicedatadisplayplatform.module.siteasset.mapper.AddressMapper;
import com.devicedatadisplayplatform.module.siteasset.service.AddressService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author 
 * Message 地址服务层实现类
 * Time 2025/12/13
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper addressMapper;

    /*
    *  获取所有地址
    * */
    @Override
    public List<Address> getAllAddresses() {
        return addressMapper.selectList(null);
    }

    /*
     *  分页获取地址
     * */
    @Override
    public IPage<Address> getAddressPage(int current, int size) {
        IPage<Address> page = new Page<>(current, size);
        return addressMapper.selectPage(page, null);
    }
    
    /*
     *  根据ID获取地址
     * */
    @Override
    public Address getAddressById(Long addressId) {
        return addressMapper.selectById(addressId);
    }
    
    /*
     *  新增地址
     * */
    @Override
    public boolean addAddress(Address address){
        // 使用 QueryWrapper 查询地址是否已存在
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("address_name", address.getAddressName());
        if(addressMapper.selectOne(queryWrapper) != null){
            return false;
        }else{
            addressMapper.insert(address);
            return true;
        }
    }

    /*
     *  更新地址
     * */
    @Override
    public boolean updateAddress(Address address){
        // 应该返回更新影响的行数是否大于0
        return addressMapper.updateById(address) > 0;
    }

    /*
     *  删除地址
     * */
    @Override
    public Boolean deleteAddress(Long addressId){
        return addressMapper.deleteById(addressId) > 0;
    }
}