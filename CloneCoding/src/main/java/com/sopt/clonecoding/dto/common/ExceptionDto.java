package com.sopt.clonecoding.dto.common;

import com.sopt.clonecoding.exception.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public record ExceptionDto(
        HttpStatus code,
         String message
) {
    public static ExceptionDto of(ErrorCode errorCode){
        return new ExceptionDto(
                errorCode.getHttpStatus(),
                errorCode.getMessage());
    }
}
