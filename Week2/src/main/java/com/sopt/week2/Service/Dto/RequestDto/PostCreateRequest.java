package com.sopt.week2.Service.Dto.RequestDto;

import jakarta.validation.constraints.Size;

public record PostCreateRequest(
        @Size(max = 10,message = "게시글 제목이 최대 글자 수(20자)를 초과했습니다.") String title,
        String content
) {

}
