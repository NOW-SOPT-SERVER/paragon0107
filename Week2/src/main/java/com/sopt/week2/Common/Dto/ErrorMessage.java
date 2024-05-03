package com.sopt.week2.Common.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage{
    BLOG_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 블로그가 존재하지 않습니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND.value(),"ID에 해당하는 사용자가 존재하지 않습니다."),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND.value(),"ID에 해당하는 게시글이 존재하지 않습니다."),
    BLOG_NOT_MATCHED_TO_MEMBER(HttpStatus.NOT_FOUND.value(),"해당 블로그에 글을 쓸 권한이 없습니다."),
    ;
    private final int status;
    private final String message;


    }
