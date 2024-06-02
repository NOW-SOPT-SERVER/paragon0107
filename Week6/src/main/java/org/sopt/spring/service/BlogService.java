package org.sopt.spring.service;

import lombok.RequiredArgsConstructor;
import org.sopt.spring.common.exception.ErrorMessage;
import org.sopt.spring.domain.Blog;
import org.sopt.spring.domain.Member;
import org.sopt.spring.external.S3Service;

import org.sopt.spring.common.exception.NotFoundException;
import org.sopt.spring.repository.BlogRepository;
import org.sopt.spring.dto.request.BlogCreateRequest;
import org.sopt.spring.dto.request.BlogTitleUpdateRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;
    private final MemberService memberService;
    private final S3Service s3Service;
    private static final String BLOG_S3_UPLOAD_FOLDER = "blog/";

    @Transactional
    public String create(Long memberId, BlogCreateRequest createRequest) {
        //member찾기
        Member member = memberService.findById(memberId);
        try {
            Blog blog = blogRepository.save(Blog.create(member, createRequest.title(), createRequest.description()));
            return blog.getId().toString();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Transactional(readOnly = true)
    public Blog findByBlogId(Long blogId){
        return blogRepository.findById(blogId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND));
    }
    @Transactional
    public void updateTitle(Long blogId, BlogTitleUpdateRequest blogTitleUpdateRequest) {
        Blog blog = findByBlogId(blogId);
        blog.updateBlogTitle(blogTitleUpdateRequest);
    }
}