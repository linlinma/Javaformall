package com.company.springbootsell.repository;

import com.company.springbootsell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTests {

    @Autowired
    OrderMasterRepository repository;
    private final String OPENID="101010";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1235");
        orderMaster.setBuyerName("小丸子");
        orderMaster.setBuyerPhone("1399");
        orderMaster.setBuyerAddress("江科大");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(14));


        OrderMaster result=repository.save(orderMaster);
        Assert.assertNotNull(result);
    }
}
