package com.sopt.week2.Service;


import static com.sopt.week2.Common.Dto.ErrorMessage.BLOG_NOT_MATCHED_TO_MEMBER;

import com.sopt.week2.Common.Dto.ErrorMessage;

import com.sopt.week2.Domain.Member;
import com.sopt.week2.Domain.Post;
import com.sopt.week2.Exception.NoAuthorizedException;
import com.sopt.week2.Exception.NotFoundException;
import com.sopt.week2.Repository.PostRepository;
import com.sopt.week2.Service.Dto.RequestDto.PostCreateRequest;
import com.sopt.week2.Service.Dto.RequestDto.PostFindDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    MemberService memberService;
    BlogService blogService;
    PostRepository postRepository;

    public String createPost(Long memberId, PostCreateRequest postCreateRequest){
        Member member = memberService.findById(memberId);
        if(postCreateRequest.blog().getMember() != member){
            throw new NoAuthorizedException(BLOG_NOT_MATCHED_TO_MEMBER);
        }
        Post post = postRepository.save(Post.create(postCreateRequest));
        return post.getId().toString();
    }
    public PostFindDto findPostById(Long postId){
        return PostFindDto.of(postRepository.findById(postId).orElseThrow(
                ()-> new NotFoundException(ErrorMessage.POST_NOT_FOUND)
        ));
    }


}
