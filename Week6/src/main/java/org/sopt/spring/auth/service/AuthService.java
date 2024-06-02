package org.sopt.spring.auth.service;

import static org.sopt.spring.common.jwt.JwtValidationType.VALID_JWT;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.PushBuilder;
import lombok.RequiredArgsConstructor;
import org.sopt.spring.auth.UserAuthentication;
import org.sopt.spring.auth.dto.TokenDto;
import org.sopt.spring.auth.dto.UserJoinResponse;
import org.sopt.spring.auth.redis.domain.Token;
import org.sopt.spring.auth.redis.repository.RedisTokenRepository;
import org.sopt.spring.common.exception.ErrorMessage;
import org.sopt.spring.common.exception.UnauthorizedException;
import org.sopt.spring.common.jwt.JwtTokenProvider;
import org.sopt.spring.domain.Member;
import org.sopt.spring.repository.MemberRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;
    private final RedisTokenRepository redisTokenRepository;
    @Transactional
    public UserJoinResponse login(String name){
        System.out.println(name);
        Member member = memberRepository.findMemberByName(name).orElseThrow(
                () -> new RuntimeException("Not found Account")
        );
        TokenDto tokenDto = generateToken(member);
        return UserJoinResponse.of(tokenDto.accessToken(), tokenDto.refreshToken(),member.getId().toString());
    }
    @Transactional
    public TokenDto generateToken(Member member){
        UserAuthentication userAuthentication = UserAuthentication.createUserAuthentication(member.getId());

        TokenDto tokenDto = jwtTokenProvider.createAllToken(userAuthentication);
        redisTokenRepository.save(Token.builder().id(member.getId()).refreshToken(tokenDto.refreshToken()).build());
        return tokenDto;
    }
    @Transactional
    public UserJoinResponse reissue(HttpServletRequest request){
        String refreshToken = getRefreshFromRequest(request);
        if(refreshToken == null){
            throw new UnauthorizedException(ErrorMessage.JWT_UNAUTHORIZED_EXCEPTION);
        }
        if(jwtTokenProvider.validateToken(refreshToken)==VALID_JWT){
            Long memberId = jwtTokenProvider.getUserFromJwt(refreshToken);
            Token token = redisTokenRepository.findById(memberId).orElseThrow(
                    () -> new RuntimeException("refresh token 만료 혹은 없음")
            );
            UserAuthentication authentication = UserAuthentication.createUserAuthentication(memberId);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            return UserJoinResponse.of(jwtTokenProvider.issueAccessToken(authentication), refreshToken,memberId.toString());
        }
        throw new UnauthorizedException(ErrorMessage.JWT_NOT_FOUND_TOKEN);
    }
    public String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring("Bearer ".length());
        }
        return null;
    }
    private String getRefreshFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Param");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring("Bearer ".length());
        }
        return null;
    }
}
