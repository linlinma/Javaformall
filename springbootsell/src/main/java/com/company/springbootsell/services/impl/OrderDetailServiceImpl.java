package com.company.springbootsell.services.impl;


import com.company.springbootsell.dataobject.OrderDetail;
import com.company.springbootsell.repository.OrderDetailRepository;
import com.company.springbootsell.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository repository;
    @Override
    public List<OrderDetail> find(String orderId) {
        return repository.findByOrderId(orderId);
    }
}
