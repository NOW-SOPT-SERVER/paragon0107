package org.example.Repogitory;

import org.example.DTO.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final UserRepository userRepository = new UserRepository();
    private UserRepository(){
    }
    public static UserRepository getInstance(){
        return userRepository;
    }
    private List<User> userList = new ArrayList<>();
    public void addUser(){

    }
    public void login(){

    }
}
