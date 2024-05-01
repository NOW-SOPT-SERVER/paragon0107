package com.sopt.week2.Common.Dto;

import com.sopt.week2.Service.Dto.RequestDto.RequestDto;
import jakarta.annotation.Nullable;

public record SuccessStatusResponse(
        int status,
        String message,
        RequestDto data
        ) {
    public static SuccessStatusResponse of(SuccessMessage successMessage,@Nullable RequestDto data){

        return new SuccessStatusResponse(successMessage.getStatus(), successMessage.getMessage(),data);
    }
}
