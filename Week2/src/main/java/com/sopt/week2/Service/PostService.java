package com.sopt.week2.Service;


import static com.sopt.week2.Common.Dto.ErrorMessage.BLOG_NOT_MATCHED_TO_MEMBER;

import com.sopt.week2.Common.Dto.ErrorMessage;

import com.sopt.week2.Domain.Blog;
import com.sopt.week2.Domain.Member;
import com.sopt.week2.Domain.Post;
import com.sopt.week2.Exception.NoAuthorizedException;
import com.sopt.week2.Exception.NotFoundException;
import com.sopt.week2.Repository.PostRepository;
import com.sopt.week2.Service.Dto.RequestDto.PostCreateRequest;
import com.sopt.week2.Service.Dto.RequestDto.PostFindDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {
    private final MemberService memberService;
    private final BlogService blogService;
    private final PostRepository postRepository;

    public String createPost(Long memberId ,Long blogId, PostCreateRequest postCreateRequest){
        Member member = memberService.findById(memberId);
        Blog blog = blogService.findById(blogId);

        if(!Objects.equals(blog.getMember().getId(), member.getId())){
            throw new NoAuthorizedException(BLOG_NOT_MATCHED_TO_MEMBER);
        }
       return postRepository.save(Post.create(blog,postCreateRequest)).getId().toString();

    }
    public PostFindDto findPostById(Long postId){
        log.info("서비스 단 진입");
        return PostFindDto.of(postRepository.findPostById(postId));
    }


}
