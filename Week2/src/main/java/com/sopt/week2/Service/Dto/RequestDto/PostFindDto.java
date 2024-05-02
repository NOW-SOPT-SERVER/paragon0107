package com.sopt.week2.Service.Dto.RequestDto;

import com.sopt.week2.Domain.Blog;
import com.sopt.week2.Domain.Post;

public record PostFindDto(
        Long id,
        Long blogId,
        String title,
        String content

) {
    public PostFindDto(Long id,Long blogId, String title, String content) {
        this.id = id;
        this.blogId = blogId;
        this.title = title;
        this.content = content;


    }
    public static PostFindDto of(Post post){
        Long blogId = post.getBlog().getId();
        return new PostFindDto(post.getId(), blogId,post.getTitle(), post.getContent());
    }
}
