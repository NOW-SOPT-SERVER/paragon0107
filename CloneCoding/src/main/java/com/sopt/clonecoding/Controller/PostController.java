package com.sopt.clonecoding.controller;

import com.sopt.clonecoding.dto.common.ResponseDto;
import com.sopt.clonecoding.dto.request.PostCreateDto;
import com.sopt.clonecoding.dto.request.UserCreateDto;
import com.sopt.clonecoding.dto.response.PostFindDto;
import com.sopt.clonecoding.dto.response.UserFindDto;
import com.sopt.clonecoding.service.PostService;
import com.sopt.clonecoding.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")

public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseDto<Long> createPost(
            @RequestBody PostCreateDto postCreateDto
    ){
        return ResponseDto.ok(postService.createPost(postCreateDto));
    }

    @GetMapping("/{postId}")
    public ResponseDto<PostFindDto> findPostById(
            @PathVariable Long postId
    ){
        return ResponseDto.created(postService.findPostById(postId));
    }
}
