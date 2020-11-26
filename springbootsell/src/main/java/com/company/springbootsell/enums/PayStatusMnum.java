package com.company.springbootsell.enums;

import lombok.Getter;

@Getter
public enum PayStatusMnum implements CodeEnum{
    WAIT(0,"等待支付"),
    SUCCESS(1,"")

    ;
    private Integer code;
    private String message;

    PayStatusMnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
