package com.sopt.clonecoding.controller;

import com.sopt.clonecoding.domain.Post;
import com.sopt.clonecoding.dto.common.ResponseDto;
import com.sopt.clonecoding.dto.request.PostCreateDto;
import com.sopt.clonecoding.dto.request.UserCreateDto;
import com.sopt.clonecoding.dto.response.PostFindDto;
import com.sopt.clonecoding.dto.response.PostFindListDto;
import com.sopt.clonecoding.dto.response.UserFindDto;
import com.sopt.clonecoding.service.PostService;
import com.sopt.clonecoding.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")

public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseDto<Long> createPost(
            @RequestHeader Long userId,
            @Valid @RequestBody PostCreateDto postCreateDto
    ){
        return ResponseDto.created(postService.createPost(userId,postCreateDto));
    }

    @GetMapping("/{postId}")
    public ResponseDto<PostFindDto> findPostById(
            @PathVariable Long postId
    ){
        return ResponseDto.ok(postService.findPostById(postId));

    }
    @PatchMapping("/{postId}/like")
    public ResponseDto<Integer> Like(
            @RequestHeader Long userId,
            @PathVariable Long postId
    ){
        return ResponseDto.ok(postService.like(postId,userId));

    }
    @GetMapping("/location/{locationId}")
    public ResponseDto<List<PostFindDto>> findPostByLocationId(
            @PathVariable int locationId
            ){
        return ResponseDto.ok(postService.findPostByLocationId(locationId));
    }
}
