package com.sopt.week2.Service;


import com.sopt.week2.Common.Dto.ErrorMessage;
import com.sopt.week2.Domain.Blog;
import com.sopt.week2.Domain.Member;
import com.sopt.week2.Domain.Post;
import com.sopt.week2.Exception.NotFoundException;
import com.sopt.week2.Repository.BlogRepository;
import com.sopt.week2.Repository.PostRepository;
import com.sopt.week2.Service.Dto.BlogCreateRequest;
import com.sopt.week2.Service.Dto.BlogTitleUpdateRequest;
import com.sopt.week2.Service.Dto.PostCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberService memberService;
    private final PostRepository postRepository;

    public String create(Long memberId, BlogCreateRequest blogCreateRequest){
        Member member = memberService.findById(memberId);
        Blog blog = blogRepository.save(Blog.create(member,blogCreateRequest));
        return blog.getId().toString();
    }
    @Transactional
    public void updateTitle(Long blogId, BlogTitleUpdateRequest blogTitleUpdateRequest) {
        Blog blog = findById(blogId);
        blog.updateTitle(blogTitleUpdateRequest.title());
    }
    public Blog findById(Long blogId){
        return blogRepository.findById(blogId).orElseThrow(
                ()-> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND)
        );
    }
    public String createPost(Long memberId, PostCreateRequest postCreateRequest){
        Member member = memberService.findById(memberId);
        Blog blog = findById(memberId);
        Post post = postRepository.save(Post.create(blog,postCreateRequest));
        return blog.getId().toString();
    }

}
