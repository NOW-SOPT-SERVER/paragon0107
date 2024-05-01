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
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostService {
    MemberService memberService;
    BlogService blogService;
    PostRepository postRepository;

    public void createPost(Long memberId ,Long blogId, PostCreateRequest postCreateRequest){
        Member member = memberService.findById(memberId);
        System.out.println(member);
        Blog blog = blogService.findById(blogId);

        if(!Objects.equals(blog.getMember().getId(), member.getId())){
            throw new NoAuthorizedException(BLOG_NOT_MATCHED_TO_MEMBER);
        }
        postRepository.save(Post.create(blog,postCreateRequest));

    }
    public PostFindDto findPostById(Long postId){
        return PostFindDto.of(postRepository.findById(postId).orElseThrow(
                ()-> new NotFoundException(ErrorMessage.POST_NOT_FOUND)
        ));
    }


}
