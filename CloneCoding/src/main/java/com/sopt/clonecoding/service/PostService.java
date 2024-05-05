package com.sopt.clonecoding.service;

import static com.sopt.clonecoding.domain.enums.Location.DAEGU;
import static com.sopt.clonecoding.domain.enums.Location.SEOUL;

import com.sopt.clonecoding.domain.Post;
import com.sopt.clonecoding.domain.User;
import com.sopt.clonecoding.domain.enums.Location;
import com.sopt.clonecoding.dto.request.PostCreateDto;
import com.sopt.clonecoding.dto.request.UserCreateDto;
import com.sopt.clonecoding.dto.response.PostFindDto;
import com.sopt.clonecoding.dto.response.PostFindListDto;
import com.sopt.clonecoding.dto.response.UserFindDto;
import com.sopt.clonecoding.exception.CustomException;
import com.sopt.clonecoding.exception.ErrorCode;
import com.sopt.clonecoding.repository.PostRepository;
import com.sopt.clonecoding.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Long createPost(Long userId, PostCreateDto postCreateDto) {
        System.out.println(userId);
        User user = userRepository.findUserById(userId);
        return switch (postCreateDto.tradeType()){
            case SALE -> {
                Post post = Post.createSalePost(
                        user,
                        postCreateDto.title(),
                        postCreateDto.description(),
                        postCreateDto.price(),
                        postCreateDto.location(),
                        postCreateDto.openOffer()
                );
                postRepository.save(post);
                yield post.getPostId();
            }
            case DRAW -> {
                Post post = Post.createDrawPost(
                        user,
                        postCreateDto.title(),
                        postCreateDto.description(),
                        postCreateDto.location(),
                        postCreateDto.openDraw()
                );
                postRepository.save(post);
                yield post.getPostId();
            }
            default -> {
                throw new CustomException(ErrorCode.POST_NOT_FOUND);
            }
        };
    }
    public PostFindDto findPostById(Long postId){
        return PostFindDto.of(postRepository.findPostById(postId));
    }

    public List<PostFindDto> findPostByLocationId(int locationId){
        return  PostFindListDto.of(postRepository.findByLocation(Location.BUSAN.getLocation(locationId)));
    }
    @Transactional
    public int like(Long postId,Long userId){
        Post post = postRepository.findPostById(postId);
        User user = userRepository.findUserById(userId);
        if(user.getLikedPosts().contains(post)){
            post.getLikedByUsers().remove(user);
            user.getLikedPosts().remove(post);
        }else {
            post.getLikedByUsers().add(user);
            user.getLikedPosts().add(post);
        }
        return post.getLikedByUsers().size();
    }


}
