package org.sopt.spring.service;

import lombok.RequiredArgsConstructor;
import org.sopt.spring.domain.Blog;

import org.sopt.spring.common.exception.ErrorMessage;
import org.sopt.spring.common.exception.NotFoundException;
import org.sopt.spring.common.exception.NotHaveBlog;

import org.sopt.spring.domain.Member;
import org.sopt.spring.domain.Post;
import org.sopt.spring.dto.request.PostCreateRequest;
import org.sopt.spring.dto.response.PostViewResponse;
import org.sopt.spring.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostService {
    private final BlogService blogService;
    private final PostRepository postRepository;
    private final MemberService memberService;
    @Transactional
    public String post(Long memberId, Long blogId, PostCreateRequest postCreateRequest) {
        Blog blog = blogService.findByBlogId(blogId);
        Member member = memberService.findById(memberId);
        if(!Objects.equals(member, blog.getMember())){
            throw new NotHaveBlog(ErrorMessage.BLOG_CANT_USE);
        }
        Post post = postRepository.save(Post.create(postCreateRequest, blog, memberId));
        blog.addPost(post);
        return post.getId().toString();
    }
    @Transactional(readOnly = true)
    public PostViewResponse getPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.POSTING_NOT_FOUND));
        return PostViewResponse.of(post);
    }
}
