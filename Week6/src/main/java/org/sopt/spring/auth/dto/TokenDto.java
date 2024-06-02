package org.sopt.spring.auth.dto;

import java.util.Stack;

public record TokenDto(
        String accessToken,
        String refreshToken
) {
    public static TokenDto of(String accessToken,String refreshToken){
        return new TokenDto(accessToken,refreshToken);
    }
}
