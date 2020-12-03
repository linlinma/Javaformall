package com.company.springbootsell.repository;

import com.company.springbootsell.dataobject.OrderMaster;
import com.company.springbootsell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
    List<OrderMaster> findByOrderIdIn(List<Integer> orderList);
}
