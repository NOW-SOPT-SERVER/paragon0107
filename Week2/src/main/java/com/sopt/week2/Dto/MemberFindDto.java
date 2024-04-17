package com.sopt.week2.Dto;

import com.sopt.week2.Domain.Member;
import com.sopt.week2.Domain.enums.Part;

public record MemberFindDto(
        Long id,
        String name,
        Part part,
        int age
) {
    public static MemberFindDto of(
            Member member
    ) {
        return new MemberFindDto(
                member.getId(),
                member.getName(),
                member.getPart(),
                member.getAge()
        );
    }
}
