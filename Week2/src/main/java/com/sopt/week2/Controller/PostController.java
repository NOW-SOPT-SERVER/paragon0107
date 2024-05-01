package com.sopt.week2.Controller;

import com.sopt.week2.Common.Dto.SuccessMessage;
import com.sopt.week2.Common.Dto.SuccessStatusResponse;
import com.sopt.week2.Service.BlogService;
import com.sopt.week2.Service.Dto.RequestDto.PostCreateRequest;
import com.sopt.week2.Service.Dto.RequestDto.PostFindDto;
import com.sopt.week2.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    BlogService blogService;
    @PostMapping("/post")
    public ResponseEntity<SuccessStatusResponse> createPost(
            @RequestHeader Long memberId,
            @RequestHeader Long blogId,
            @Valid @RequestBody PostCreateRequest postCreateRequest
    ){
        postService.createPost(memberId,blogId,postCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(SuccessStatusResponse.of(SuccessMessage.POST_CREAT_SUCCESS,null));
    }
    @GetMapping("/post/{postId}")
    public ResponseEntity<SuccessStatusResponse> findPostById(
            @PathVariable Long postId
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessStatusResponse.of(SuccessMessage.POST_SEARCH_SUCCESS,postService.findPostById(postId)));
    }
}
