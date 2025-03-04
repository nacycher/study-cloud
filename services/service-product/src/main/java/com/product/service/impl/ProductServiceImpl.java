package com.product.service.impl;

import com.product.Product;
import com.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setProductName("华为手机");
        product.setPrice(new BigDecimal(1000));
        product.setNum(100);
        // 模拟API超时
        try {
            Thread.sleep(1000 * 100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
}
