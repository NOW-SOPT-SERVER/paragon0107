package com.sopt.clonecoding.dto.request;

import com.sopt.clonecoding.domain.enums.Location;
import com.sopt.clonecoding.domain.enums.TradeType;
import jakarta.validation.constraints.Size;

public record PostCreateDto(
        @Size(max = 20,message = "게시글 제목이 최대 글자 수(20자)를 초과했습니다.") String title,
        TradeType tradeType,
        int price,
        boolean openOffer,
        boolean openDraw,
        String description,
        Location location
) {
}
