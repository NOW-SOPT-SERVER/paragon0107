package com.sopt.clonecoding.controller;

import com.sopt.clonecoding.domain.User;
import com.sopt.clonecoding.dto.common.ResponseDto;
import com.sopt.clonecoding.dto.request.UserCreateDto;
import com.sopt.clonecoding.dto.response.UserFindDto;
import com.sopt.clonecoding.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseDto<String> createUser(
            @RequestBody final UserCreateDto userCreateDto
    ){
        return ResponseDto.ok(userService.createUser(userCreateDto));
    }

    @GetMapping("/{userId}")
    public ResponseDto<UserFindDto> findMemberById(
            @PathVariable Long userId
    ){
        return ResponseDto.created(userService.findUserById(userId));
    }
}
