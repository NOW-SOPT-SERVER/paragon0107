package com.sopt.week2.Common.Dto;

public record SuccessStatusResponse(
        int status,
        String message
) {
    public static SuccessStatusResponse of(SuccessMessage successMessage){

        return new SuccessStatusResponse(successMessage.getStatus(), successMessage.getMessage());
    }
}
