package com.company.springbootsell.services;

import com.company.springbootsell.dataobject.OrderMaster;
import com.company.springbootsell.dataobject.ProductCategory;
import com.company.springbootsell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    public OrderMaster findOne(String orderId);

    public List<OrderMaster> findAll();

    //分页查询所有商品
    Page<OrderMaster> findAll(Pageable pageable);

    public List<OrderMaster> findByOrderIdIn(List<Integer> orderList);

    public OrderMaster save(OrderMaster orderMaster);

}
