package com.sopt.week2.Service.Dto.RequestDto;


import com.sopt.week2.Domain.enums.Part;

public record MemberCreateDto(
        String name,
        Part part,
        int age
) {
}