package org.sopt.spring.dto.response;

import org.sopt.spring.domain.Post;

public record PostViewResponse(
        String title,
        String content
) {
    public static PostViewResponse of(Post post) {
        return new PostViewResponse(post.getTitle(), post.getContent());
    }
}
