package com.sopt.week2.Exception;


import com.sopt.week2.Common.Dto.ErrorMessage;

public class NoAuthorizedException extends BusinessException {
    public NoAuthorizedException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
