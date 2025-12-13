package com.devicedatadisplayplatform.module.siteasset.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.devicedatadisplayplatform.common.result.Result;
import com.devicedatadisplayplatform.common.util.ConvertUtil;
import com.devicedatadisplayplatform.module.siteasset.form.ProductForm;
import com.devicedatadisplayplatform.module.siteasset.domain.Product;
import com.devicedatadisplayplatform.module.siteasset.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author 
 * Message 产品控制器
 * Time 2025/12/13
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/listProduct")
    public Result<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return Result.ok(products);
    }

    @GetMapping("/pageProduct")
    public Result<IPage<Product>> getProductPage(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "10") int size) {
        IPage<Product> page = productService.getProductPage(current, size);
        return Result.ok(page);
    }
    
    @GetMapping("/getProduct")
    public Result<Product> getProductById(@RequestParam Long productId) {
        Product product = productService.getProductById(productId);
        return Result.ok(product);
    }

    @PostMapping("/addProduct")
    public Result<String> addProduct(@RequestBody ProductForm productForm) {
        Product product = ConvertUtil.convert(productForm, Product.class);
        boolean success = productService.addProduct(product);
        if (success) {
            return Result.ok("产品新增成功");
        } else {
            return Result.fail("产品新增失败");
        }
    }

    @PostMapping("/updateProduct")
    public Result<String> updateProduct(@RequestBody ProductForm productForm) {
        Product product = ConvertUtil.convert(productForm, Product.class);
        boolean success = productService.updateProduct(product);
        if (success) {
            return Result.ok("产品更新成功");
        } else {
            return Result.fail("产品更新失败");
        }
    }

    @GetMapping("/deleteProduct")
    public Result<String> deleteProduct(@RequestParam Long productId) {
        boolean success = productService.deleteProduct(productId);
        if (success) {
            return Result.ok("产品删除成功");
        } else {
            return Result.fail("产品删除失败");
        }
    }
}