package com.sopt.clonecoding.domain.enums;

import ch.qos.logback.core.util.Loader;
import com.sopt.clonecoding.exception.CustomException;
import com.sopt.clonecoding.exception.ErrorCode;
import java.util.Arrays;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Location {
    SEOUL("서울특별시",11),
    BUSAN("부산광역시",26),
    DAEGU("대구광역시",27),
    INCHEON("인천광역시",28),
    GWANGJU("광주광역시",29),
    DAEJEON("대전광역시",30),
    ;
    //힘들다... 여기까지만 할게요 기타 등등~~

    private final String location;
    private final int id;
    public Location getLocation(int locationId){
        return Arrays.stream(Location.values()).filter(location -> locationId == location.id).findFirst().orElseThrow(
                ()-> new CustomException(ErrorCode.LOCATION_NOT_FOUND)
        );
    }


}
