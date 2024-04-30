package com.sopt.week2.Controller;


import com.sopt.week2.Common.Dto.SuccessMessage;
import com.sopt.week2.Common.Dto.SuccessStatusResponse;
import com.sopt.week2.Service.BlogService;
import com.sopt.week2.Service.Dto.BlogCreateRequest;
import com.sopt.week2.Service.Dto.BlogTitleUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.servlet.function.ServerResponse.status;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<SuccessStatusResponse> createBlog(
            @RequestHeader Long memberId,
            @RequestBody BlogCreateRequest blogCreateRequest
    ){

        return ResponseEntity.status(HttpStatus.CREATED).header("Location",blogService.create(memberId,blogCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.BlOG_CREAT_SUCCESS));
    }

    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity updateBlogTitle(
            @PathVariable Long blogId,
           @Valid @RequestBody BlogTitleUpdateRequest blogTitleUpdateRequest
    ) {
        blogService.updateTitle(blogId, blogTitleUpdateRequest);
        return ResponseEntity.noContent().build();
    }

}

