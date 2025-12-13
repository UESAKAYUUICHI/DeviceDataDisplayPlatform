package com.devicedatadisplayplatform.module.siteasset.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.devicedatadisplayplatform.module.siteasset.domain.Product;

import java.util.List;

/**
 * Author 
 * Message 产品服务层
 * Time 2025/12/13
 */
public interface ProductService {

    /*
    *  获取所有产品
    * */
    List<Product> getAllProducts();

    /*
     *  分页查询产品
     * */
    IPage<Product> getProductPage(int current, int size);
    
    /*
     *  根据ID获取产品
     * */
    Product getProductById(Long productId);

    /*
     *  新增产品
     * */
    boolean addProduct(Product product);

    /*
     *  更新产品
     * */
    boolean updateProduct(Product product);

    /*
     *  删除产品
     * */
    Boolean deleteProduct(Long productId);
}