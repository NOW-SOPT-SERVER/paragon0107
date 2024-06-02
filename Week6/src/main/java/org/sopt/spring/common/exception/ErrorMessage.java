package org.sopt.spring.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다"),
    BLOG_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 블로그가 존재하지 않습니다"),
    BLOG_CANT_USE(HttpStatus.NOT_FOUND.value(), "사용자의 블로그가 아닙니다."),
    POSTING_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 사용자가 존재하지 않습니다"),
    JWT_UNAUTHORIZED_EXCEPTION(HttpStatus.UNAUTHORIZED.value(), "사용자의 로그인 검증을 실패했습니다."),
    JWT_NOT_FOUND_TOKEN(HttpStatus.NOT_FOUND.value(),"토큰이 존재하지 않습니다.")
    ;
    private final int status;
    private final String message;
}

