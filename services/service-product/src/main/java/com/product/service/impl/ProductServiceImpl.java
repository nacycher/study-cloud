package com.product.service.impl;

import com.product.bean.Product;
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
        return product;
    }
}
