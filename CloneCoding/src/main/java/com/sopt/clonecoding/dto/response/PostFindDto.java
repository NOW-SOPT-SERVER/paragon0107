package com.sopt.clonecoding.dto.response;

import com.sopt.clonecoding.domain.Post;
import com.sopt.clonecoding.domain.User;
import com.sopt.clonecoding.domain.enums.Location;
import com.sopt.clonecoding.domain.enums.Status;
import com.sopt.clonecoding.domain.enums.TradeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;


public record PostFindDto(
        Long postId,
        UserFindDto user,
        String title,
        TradeType tradeType,
        int price,
        boolean openOffer,
        boolean openDraw,
        String description,
        Location location,
        Status status,
        int likeCount
) {
    public static PostFindDto of(Post post){
        return new PostFindDto(
                post.getPostId(),
                UserFindDto.of(post.getUser()),
                post.getTitle(),
                post.getTradeType(),
                post.getPrice(),
                post.isOpenOffer(),
                post.isOpenDraw(),
                post.getDescription(),
                post.getLocation(),
                post.getStatus(),
                post.getLikedByUsers().size()
        );
    }
}
