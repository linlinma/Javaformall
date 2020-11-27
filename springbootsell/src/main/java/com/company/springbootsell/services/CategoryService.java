package com.company.springbootsell.services;

import com.company.springbootsell.dataobject.ProductCategory;
import lombok.Getter;

import java.util.List;

public interface CategoryService {
    public ProductCategory findOne(Integer categoryId);

    public List<ProductCategory> findAll();

    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    public ProductCategory save(ProductCategory productCategory);


}
