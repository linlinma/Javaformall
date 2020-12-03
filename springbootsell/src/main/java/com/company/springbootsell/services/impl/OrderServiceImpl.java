package com.company.springbootsell.services.impl;

import com.company.springbootsell.Exception.SellException;
import com.company.springbootsell.dataobject.OrderMaster;
import com.company.springbootsell.dataobject.ProductInfo;
import com.company.springbootsell.enums.OrderStatusEnum;
import com.company.springbootsell.enums.ProductStatusEnum;
import com.company.springbootsell.enums.ResultEnum;
import com.company.springbootsell.repository.OrderMasterRepository;
import com.company.springbootsell.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMasterRepository repository;
    @Override
    public  OrderMaster findOne(String orderId) {

        return repository.findOne(orderId);
    }

    @Override
    public List<OrderMaster> findAll() {
        return repository.findAll();
    }
    @Override
    public Page<OrderMaster> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<OrderMaster> findByOrderIdIn(List<Integer> orderList) {
        return repository.findByOrderIdIn(orderList);
    }

    @Override
    public OrderMaster save(OrderMaster orderMaster) {
        return repository.save(orderMaster);
    }

    @Override
    public OrderMaster offOrder(String orderId) {
        OrderMaster orderMaster= repository.findOne(orderId);
        if (orderMaster.getOrderStatus()==0){
            orderMaster.setOrderStatus(2);
        }

        return repository.save(orderMaster);
    }
}
