package com.sopt.clonecoding.dto.response;


import com.sopt.clonecoding.domain.User;

public record UserFindDto(
        Long userId,
        String nickname
) {
    public UserFindDto(Long userId, String nickname){
        this.userId = userId;
        this.nickname = nickname;
    }
    public static UserFindDto of(User user){
        return new UserFindDto(user.getUserId(), user.getNickName()) ;
    }
}
