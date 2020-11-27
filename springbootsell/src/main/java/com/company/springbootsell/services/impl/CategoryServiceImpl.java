package com.company.springbootsell.services.impl;

import com.company.springbootsell.dataobject.ProductCategory;
import com.company.springbootsell.dataobject.ProductInfo;
import com.company.springbootsell.repository.ProductCategoryRepository;
import com.company.springbootsell.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired

    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {


        return repository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
        //return repository.findByCategoryIdIn(CategoryTypeList)
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
