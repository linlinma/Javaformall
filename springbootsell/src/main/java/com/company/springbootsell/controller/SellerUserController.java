package com.company.springbootsell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/seller/user")
public class SellerUserController {
//    @Autowired
//    private UserService userService;

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "Id",required = false) String Id,
                              BindingResult bindingResult,
                              Map<String, Object> map){
        if (Id!=null){
            //修改
            return new ModelAndView("/seller/product/list");
//            ProductCategory productCategory= categoryService.findOne(categoryId);
//            map.put("productCategory",productCategory);
        }else {
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/seller/product/index");
            return new ModelAndView("common/error", map);
        }

    }

}
