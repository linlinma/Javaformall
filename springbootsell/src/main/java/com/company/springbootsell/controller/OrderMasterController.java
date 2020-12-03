package com.company.springbootsell.controller;

import com.company.springbootsell.dataobject.OrderMaster;
import com.company.springbootsell.services.OrderService;
import me.chanjar.weixin.mp.builder.kefu.MpNewsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

}
