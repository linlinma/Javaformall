package com.company.springbootsell.controller;

import com.company.springbootsell.Exception.SellException;
import com.company.springbootsell.dataobject.ProductCategory;
import com.company.springbootsell.form.CategoryForm;
import com.company.springbootsell.form.ProductForm;
import com.company.springbootsell.services.CategoryService;
import com.company.springbootsell.utils.KeyUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map){
        List<ProductCategory> list = categoryService.findAll();
        for(ProductCategory p: list){
            System.out.println(p);
        }
        // 将list添加到map中
        map.put("categoryList", list);
        return new ModelAndView("category/list", map);
    }
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                              Map<String, Object> map){
        if (categoryId!=null){
            //修改
           ProductCategory productCategory= categoryService.findOne(categoryId);
           map.put("productCategory",productCategory);
        }
        return new ModelAndView("category/index");
    }
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map){
        if (bindingResult.hasErrors()){
            //返回错误对象
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/seller/category/index");
            return new ModelAndView("common/error",map);
        }
       ProductCategory productCategory= new ProductCategory();
      try {
         // form.setCategoryId(KeyUtil.genUniqueKey());
          //Integer.toString(form.getCategoryId())
          if (form.getCategoryId()!=null){
              // 有ProductId  修改
              productCategory = categoryService.findOne(form.getCategoryId());
          }
          BeanUtils.copyProperties(form,productCategory);
          categoryService.save(productCategory);
      }catch (SellException exception){
          map.put("msg",exception.getMessage());
          map.put("url","/seller/category/index");
          return new ModelAndView("common/error",map);
      }
      map.put("url","/seller/category/list");
        return new ModelAndView("common/success",map);
    }
}
