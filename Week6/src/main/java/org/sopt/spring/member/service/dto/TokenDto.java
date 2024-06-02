package org.sopt.spring.member.service.dto;

import java.util.Stack;

public record TokenDto(
        String accessToken,
        String refreshToken
) {
    public static TokenDto of(String accessToken,String refreshToken){
        return new TokenDto(accessToken,refreshToken);
    }
}
