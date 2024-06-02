package org.sopt.spring.common.auth.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.sopt.spring.common.auth.UserAuthentication;
import org.sopt.spring.common.auth.redis.repository.RedisTokenRepository;
import org.sopt.spring.common.exception.ErrorMessage;
import org.sopt.spring.common.exception.UnauthorizedException;
import org.sopt.spring.common.jwt.JwtTokenProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.sopt.spring.common.jwt.JwtValidationType.EXPIRED_JWT_TOKEN;
import static org.sopt.spring.common.jwt.JwtValidationType.VALID_JWT;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final RedisTokenRepository redisTokenRepository;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        try {
            final String token = getJwtFromRequest(request);
            if (jwtTokenProvider.validateToken(token) == VALID_JWT ) {
                Long memberId = jwtTokenProvider.getUserFromJwt(token);
                UserAuthentication authentication = UserAuthentication.createUserAuthentication(memberId);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }else if(redisTokenRepository.findByRefreshToken(getRefreshFromRequest(request)).isPresent()){
                final String refreshToken = getRefreshFromRequest(request);
                if(jwtTokenProvider.validateToken(refreshToken) == VALID_JWT){
                    Long memberId = jwtTokenProvider.getUserFromJwt(refreshToken);
                    UserAuthentication authentication = UserAuthentication.createUserAuthentication(memberId);
                    response.setHeader("Authorization",jwtTokenProvider.issueAccessToken(authentication));
                }
            }
        } catch (Exception exception) {
            throw new UnauthorizedException(ErrorMessage.JWT_UNAUTHORIZED_EXCEPTION);
        }
        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring("Bearer ".length());
        }
        return null;
    }
    private String getRefreshFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("refreshToken");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring("Bearer ".length());
        }
        return "";
    }
}