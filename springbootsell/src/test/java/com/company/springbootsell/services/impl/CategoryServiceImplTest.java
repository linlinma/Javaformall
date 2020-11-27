package com.company.springbootsell.services.impl;

import com.company.springbootsell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Test
    public void findOne(){
        ProductCategory productCategory=categoryService.findOne(3);
        System.out.println(productCategory);
        Assert.assertEquals(new Integer(3),productCategory.getCategoryId());

    }

    @Test
    public void findAll(){
        List<ProductCategory> list=categoryService.findAll();
        //for 增强遍历循环， 返回对象类型+对象名+集合  程序
        for (ProductCategory category:list){
            System.out.println(category);
            Assert.assertNotEquals(0,list.size());
            //assertNotEquals 得到数组不为0  测试通过
        }
    }
   @Test
    public void findByCategoryTypeIn(){
       List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(2, 3, 21));
       for (ProductCategory category:list){
           System.out.println(category);
       }
        Assert.assertNotEquals(3,list.size());
    }
    @Test
    public void save(){
        ProductCategory category=new ProductCategory("炸鸡汉堡",3);
        ProductCategory productCategory=categoryService.save(category);
        Assert.assertNotNull(productCategory);
    }
}
