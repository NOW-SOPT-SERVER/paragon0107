package com.sopt.clonecoding.domain.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Location {
    SEOUL("서울특별시",11),
    BUSAN("부산광역시",26),
    DAEGU("대구광역시",27),
    INCHEON("인천광역시",28),
    GWANGJU("광주광역시",29),
    DAEJEON("대전광역시",30),
    ETC("기타등등,,,",0)
    ;
    //힘들다... 여기까지만 할게요 기타 등등~~

    private final String location;
    private final int code;
}
