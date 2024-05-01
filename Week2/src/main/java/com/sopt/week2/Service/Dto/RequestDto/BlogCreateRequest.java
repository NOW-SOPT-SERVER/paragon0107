package com.sopt.week2.Service.Dto.RequestDto;

public record BlogCreateRequest (
        String title,
        String description
)implements RequestDto {

}
