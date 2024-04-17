package com.sopt.week2.Execption.member;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorMessage {
    INVALID_MEMBER("ID에 해당하는 사용자가 존재하지 않습니다."),
    ;
    public final String message;

    }
