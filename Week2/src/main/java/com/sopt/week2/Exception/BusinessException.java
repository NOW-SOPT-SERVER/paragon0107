package com.sopt.week2.Exception;


import com.sopt.week2.Common.Dto.ErrorMessage;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
