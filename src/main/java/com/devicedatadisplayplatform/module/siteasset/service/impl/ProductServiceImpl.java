package com.devicedatadisplayplatform.module.siteasset.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.devicedatadisplayplatform.module.siteasset.domain.Product;
import com.devicedatadisplayplatform.module.siteasset.mapper.ProductMapper;
import com.devicedatadisplayplatform.module.siteasset.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author 
 * Message 产品服务层实现类
 * Time 2025/12/13
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    /*
    *  获取所有产品
    * */
    @Override
    public List<Product> getAllProducts() {
        return productMapper.selectList(null);
    }

    /*
     *  分页获取产品
     * */
    @Override
    public IPage<Product> getProductPage(int current, int size) {
        IPage<Product> page = new Page<>(current, size);
        return productMapper.selectPage(page, null);
    }
    
    /*
     *  根据ID获取产品
     * */
    @Override
    public Product getProductById(Long productId) {
        return productMapper.selectById(productId);
    }
    
    /*
     *  新增产品
     * */
    @Override
    public boolean addProduct(Product product){
        // 使用 QueryWrapper 查询产品是否已存在
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_name", product.getProductName());
        if(productMapper.selectOne(queryWrapper) != null){
            return false;
        }else{
            productMapper.insert(product);
            return true;
        }
    }

    /*
     *  更新产品
     * */
    @Override
    public boolean updateProduct(Product product){
        // 应该返回更新影响的行数是否大于0
        return productMapper.updateById(product) > 0;
    }

    /*
     *  删除产品
     * */
    @Override
    public Boolean deleteProduct(Long productId){
        return productMapper.deleteById(productId) > 0;
    }
}