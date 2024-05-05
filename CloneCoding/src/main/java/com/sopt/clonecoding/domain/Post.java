package com.sopt.clonecoding.domain;


import com.sopt.clonecoding.domain.enums.Location;
import com.sopt.clonecoding.domain.enums.Status;
import com.sopt.clonecoding.domain.enums.TradeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String title;
    private TradeType tradeType;
    private int price;
    private boolean openOffer;
    private boolean openDraw;
    private String description;
    private Location location;
    private Status status;

    @Builder
    private Post(User user,
                 String title,
                 TradeType tradeType,
                 int price,
                 boolean openOffer,
                 boolean openDraw,
                 String description,
                Location location,
                Status status
    ) {
        this.user = user;
        this.title = title;
        this.tradeType = tradeType;
        this.price = price;
        this.openOffer = openOffer;
        this.openDraw = openDraw;
        this.description = description;
        this.location = location;
        this.status = status;
    }


    public static Post createSalePost(
            User user,
            String title,
            String description,
            int price,
            Location location,
            boolean openOffer
    ){
        return Post.builder()
                .user(user)
                .title(title)
                .description(description)
                .price(price)
                .location(location)
                .openOffer(openOffer)
                .openDraw(false)
                .tradeType(TradeType.SALE)
                .status(Status.AVAILABLE)
                .build();
    }
    public static Post createDrawPost(
            User user,
            String title,
            String description,
            Location location,
            boolean openDraw
    ){
        return Post.builder()
                .user(user)
                .title(title)
                .description(description)
                .price(0)
                .location(location)
                .openOffer(false)
                .openDraw(openDraw)
                .tradeType(TradeType.DRAW)
                .status(Status.AVAILABLE)
                .build();
    }

}
