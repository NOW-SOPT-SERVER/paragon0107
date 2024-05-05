package com.sopt.clonecoding.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND,"유저를 찾을 수 없습니다.")
    ;
    private final HttpStatus httpStatus;
    private final String message;

}
