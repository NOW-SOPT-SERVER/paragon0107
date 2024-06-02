package org.sopt.spring.controller.auth;

import static org.sopt.spring.common.success.SuccessMessage.ACCESS_TOKEN_REGENERATE;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.sopt.spring.auth.dto.UserJoinResponse;
import org.sopt.spring.auth.service.AuthService;
import org.sopt.spring.common.success.SuccessMessage;
import org.sopt.spring.common.success.SuccessStatusResponse;
import org.sopt.spring.domain.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<UserJoinResponse> LoginMember(
            @RequestBody String name
            ) {
        UserJoinResponse userJoinResponse = authService.login(name);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", userJoinResponse.userId())
                .body(
                        userJoinResponse
                );
    }
    @PostMapping("/reissue")
    public ResponseEntity<UserJoinResponse> reissue(
            HttpServletRequest request
            ){
        UserJoinResponse userJoinResponse = authService.reissue(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", userJoinResponse.userId())
                .body(
                        userJoinResponse
                );
    }


}
