package com.sopt.clonecoding.domain.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public enum Status {
    AVAILABLE("거래중"),
    RESERVED("예약중"),
    SOLD_OUT("거래완료"),
    GIVEN_AWAY("나눔완료")


    ;
    private final String status;


}
