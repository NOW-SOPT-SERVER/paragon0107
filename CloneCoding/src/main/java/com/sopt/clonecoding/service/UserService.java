package com.sopt.clonecoding.service;

import com.sopt.clonecoding.domain.User;
import com.sopt.clonecoding.dto.request.UserCreateDto;
import com.sopt.clonecoding.dto.response.UserFindDto;
import com.sopt.clonecoding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;

    public String createUser(UserCreateDto userCreateDto) {
        User user = User.create(userCreateDto.nickname());
        userRepository.save(user);
        return user.getUserId().toString();
    }
    public UserFindDto findUserById(Long userId){
        return UserFindDto.of(userRepository.findUserById(userId));
    }

}
