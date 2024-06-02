package org.sopt.spring.member.dto;

import org.sopt.spring.member.domain.Part;

public record MemberCreateDto(
        String name,
        String email,
        String password,
        Part part,
        int age
) {
}
