package com.company.springbootsell.services.impl;

import com.company.springbootsell.dataobject.ProductInfo;
import com.company.springbootsell.repository.ProductInfoRepository;
import com.company.springbootsell.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ProductServiceImpl implements ProductService {
    @Autowired

    private ProductInfoRepository repository;

    @Override


    public ProductInfo findOne(String produceId) {
        return null;
    }

    @Override
    public Page<ProductInfo> fingAll(Pageable pageable) {
        return null;
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return null;
    }

    @Override
    public void increaseStock(String producuId) {

    }

    @Override
    public void decreaseStock(String productId) {

    }
}
