package com.sopt.week2.Common.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;

public record SuccessStatusResponse<T>(
        int status,
        String message,
        T data
        ) {
    public static <T>SuccessStatusResponse<T> of(SuccessMessage successMessage,@Nullable T data){

        return new SuccessStatusResponse<T>(successMessage.getStatus(), successMessage.getMessage(),data);
    }

}
