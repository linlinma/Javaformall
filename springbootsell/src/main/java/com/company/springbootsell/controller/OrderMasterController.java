package com.company.springbootsell.controller;

import com.company.springbootsell.Exception.SellException;
import com.company.springbootsell.dataobject.OrderMaster;
import com.company.springbootsell.dataobject.ProductCategory;
import com.company.springbootsell.dataobject.ProductInfo;
import com.company.springbootsell.form.OrderForm;
import com.company.springbootsell.form.ProductForm;
import com.company.springbootsell.services.OrderService;
import com.company.springbootsell.utils.KeyUtil;
import me.chanjar.weixin.mp.builder.kefu.MpNewsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
@RequestMapping("/seller/order")
public class OrderMasterController {
@Autowired
    private OrderService orderService;
@GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "5")Integer size,
                             Map<String, Object> map){
    PageRequest pageRequest= new PageRequest(page-1,size);
   Page<OrderMaster> orderMasterPage= orderService.findAll(pageRequest);
   map.put("orderMasterPage",orderMasterPage);
   map.put("currentPage",page);
   map.put("size",size);
    return new ModelAndView("order/list",map);
}
@GetMapping("/index")
public ModelAndView index(@RequestParam(value = "orderId", required = false) String orderId,
                          Map<String, Object> map){
    if(orderId!=null){
        // 修改
        OrderMaster orderMaster = orderService.findOne(orderId);
        map.put("orderMaster", orderMaster);
    }
    List<OrderMaster> orderMasterList = orderService.findAll();
    map.put("orderMasterList", orderMasterList);
    return new ModelAndView("order/index");
}
    @PostMapping("/save")
    public ModelAndView save(@Valid OrderForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map
    ){
        if (bindingResult.hasErrors()){
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/seller/order/index");
            return new ModelAndView("common/error", map);
        }

        OrderMaster orderMaster = new OrderMaster();
        try {
            //        productInfo.setProductName(form.getProductName());
            if (!StringUtils.isEmpty(form.getOrderId())){
                // 有ProductId  修改
                orderMaster = orderService.findOne(form.getOrderId());
            }else {
                // 新增  生成一个id
                form.setOrderId(KeyUtil.genUniqueKey());
            }

            BeanUtils.copyProperties(form, orderMaster);
            orderService.save(orderMaster);

        }catch (SellException exception){
            map.put("msg", exception.getMessage());
            map.put("url", "/seller/order/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/order/list");
        return new ModelAndView("common/success", map);

    }
    @GetMapping("/off_order")
    public ModelAndView offOrder(@RequestParam("orderId")String orderId,
                                Map<String,Object> map){
        try{
            orderService.offOrder(orderId);
        }catch (SellException e){
            map.put("msg",e.getMessage());
            map.put("url","seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("url","seller/order/list");
        return new ModelAndView("common/success",map);
    }
}
