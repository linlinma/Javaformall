package com.company.springbootsell.form;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class OrderForm {

    private String orderId;

    /** 买家名字 */
    private String buyerName;

    /** 买家手机号 */
    private String buyerPhone;

    /** 买家地址  */
    private String buyerAddress;

    /** 买家微信 openId*/
    private String  buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;
}
