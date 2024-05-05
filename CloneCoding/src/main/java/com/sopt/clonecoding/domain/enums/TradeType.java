package com.sopt.clonecoding.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TradeType {
    SALE("판매하기"),
    DRAW("나늄하기")
    ;
    private final String message;
}
