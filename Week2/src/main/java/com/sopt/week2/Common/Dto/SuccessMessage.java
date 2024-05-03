package com.sopt.week2.Common.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessMessage {
    BlOG_CREAT_SUCCESS(HttpStatus.CREATED.value(),"블로그 생성이 완료되었습니다."),
    POST_CREAT_SUCCESS(HttpStatus.CREATED.value(),"게시글 생성이 완료되었습니다."),
    POST_SEARCH_SUCCESS(HttpStatus.OK.value(),"게시글 검색에 성공했습니다.")

    ;
    private final int status;
    private final String message;
}
