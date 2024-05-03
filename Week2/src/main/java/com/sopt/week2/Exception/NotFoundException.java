package com.sopt.week2.Exception;

import com.sopt.week2.Common.Dto.ErrorMessage;

public class NotFoundException extends BusinessException{
    public NotFoundException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
