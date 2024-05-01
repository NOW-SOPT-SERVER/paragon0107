package com.sopt.week2.Service.Dto.RequestDto;

import com.sopt.week2.Domain.Blog;
import com.sopt.week2.Domain.Post;

public record PostFindDto(
        Long id,
        String title,
        String content,
        Blog blog
) implements RequestDto{
    public PostFindDto(Long id, String title, String content, Blog blog) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.blog = blog;
    }
    public static PostFindDto of(Post post){
        return new PostFindDto(post.getId(), post.getTitle(), post.getContent(), post.getBlog());
    }
}
