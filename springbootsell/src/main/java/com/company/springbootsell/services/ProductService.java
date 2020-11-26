package com.company.springbootsell.services;

import com.company.springbootsell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    //查询一个商品
   ProductInfo findOne(String produceId);
   //查询一个商品
    List<ProductInfo>  findUpAll;
    //分页查询所有商品
    Page<ProductInfo> fingAll(Pageable pageable);
    //新增商品
    ProductInfo save(ProductInfo productInfo);
    //上架
    void increaseStock(String producuId);
    //下架
    void  decreaseStock(String productId);
    //加库存

    //减库存
}
