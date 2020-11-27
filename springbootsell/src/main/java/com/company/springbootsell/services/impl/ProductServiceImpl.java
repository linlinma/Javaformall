package com.company.springbootsell.services.impl;

import com.company.springbootsell.Exception.SellException;
import com.company.springbootsell.dataobject.ProductInfo;
import com.company.springbootsell.enums.ProductStatusEnum;
import com.company.springbootsell.enums.ResultEnum;
import com.company.springbootsell.repository.ProductInfoRepository;
import com.company.springbootsell.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired

    private ProductInfoRepository repository;

    @Override


    public ProductInfo findOne(String productId) {

        return repository.findOne(productId);

    }

    @Override
    public List<ProductInfo> findUpAll() {

        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());

    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        Page<ProductInfo> productInfoPage=repository.findAll(pageable);
        return productInfoPage;
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
        //return null;
    }

    @Override
    public ProductInfo onSale(String productId) {
        //查询
      ProductInfo productInfo= repository.findOne(productId);
      if (productInfo==null){
         throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
      }
      if (productInfo.getProductStatus()==ProductStatusEnum.UP.getCode()){
          throw  new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
      }
      //更改值
      productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        return repository.save(productInfo);
    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo= repository.findOne(productId);
        if (productInfo==null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (productInfo.getProductStatus()==ProductStatusEnum.DOWN.getCode()){
            throw  new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        //更改值
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return repository.save(productInfo);
    }

    @Override
    public void increaseStock(String producuId) {

    }

    @Override
    public void decreaseStock(String productId) {

    }
}
