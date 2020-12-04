package com.company.springbootsell.services;

import com.company.springbootsell.dataobject.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> find(String orderId);
}
