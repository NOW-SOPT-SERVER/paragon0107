package org.sopt.spring.common.auth.redis.repository;

import java.util.Optional;

import org.sopt.spring.common.auth.redis.domain.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;


public interface RedisTokenRepository extends CrudRepository<Token,Long> {
    Optional<Token> findByRefreshToken(final String refreshToken);
    Optional<Token> findById(final Long id);
}
