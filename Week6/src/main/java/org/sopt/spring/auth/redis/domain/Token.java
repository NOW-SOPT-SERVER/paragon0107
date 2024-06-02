package org.sopt.spring.auth.redis.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;


@RedisHash(value = "",timeToLive = 60*60*24*1000L*14)
@Getter
@Builder
@AllArgsConstructor
public class Token {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Indexed
    private String refreshToken;

    public static Token of(
            final Long id,
            final String refreshToken
    ){
        return Token.builder()
                .id(id)
                .refreshToken(refreshToken)
                .build();
    }
    public void updateToken(final String refreshToken){
        this.refreshToken=refreshToken;
    }
}
