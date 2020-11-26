package com.company.springbootsell.services.impl;

import com.company.springbootsell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImplTests {
    @Autowired
   private ProductServiceImpl productService;
    @Test
    public void findOne(){
        ProductInfo productInfo=productService.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }
}

