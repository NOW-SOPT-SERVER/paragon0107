package com.sopt.clonecoding.dto.response;

import com.sopt.clonecoding.domain.Post;
import com.sopt.clonecoding.domain.enums.Location;
import com.sopt.clonecoding.domain.enums.Status;
import com.sopt.clonecoding.domain.enums.TradeType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public record PostFindListDto(Long postId,
                              UserFindDto user,
                              String title,
                              TradeType tradeType,
                              int price,
                              boolean openOffer,
                              boolean openDraw,
                              String description,
                              Location location,
                              Status status
) {
    public static List<PostFindDto> of(List<Post> posts){
        List<PostFindDto> list = new ArrayList<>();
        for(Post post:posts){
            list.add(PostFindDto.of(post));
        }
        return list;
    }

}
