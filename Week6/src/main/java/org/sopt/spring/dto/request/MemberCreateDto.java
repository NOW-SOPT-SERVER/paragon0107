package org.sopt.spring.dto.request;

import org.sopt.spring.domain.Part;

public record MemberCreateDto(
        String name,
        String email,
        String password,
        Part part,
        int age
) {
}
