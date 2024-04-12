package org.example.Repogitory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.example.DTO.User;

import java.util.ArrayList;
import java.util.List;
import org.example.View.InputView;

public class UserRepository {
     public User loginUser = null;
    private static final UserRepository userRepository = new UserRepository();
    private UserRepository(){

    }
    public static UserRepository getInstance(){
        return userRepository;
    }
    private Map<String,User> userList = new HashMap<>();
    public void addUser(){
        String name,id;
        int password;
        name = InputView.setName();
        id = InputView.setId();
        password = InputView.setPassword();
        try{
            if(userList.containsKey(id)){
                throw new IllegalArgumentException("동일한 아이디 존재");
            }
            userList.put(id,User.create(name,id,password));
            System.out.println("유저 생성 성공");
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }
    public void loginOrLogout(){
        if(loginUser != null){
            loginUser = null;
            System.out.println("로그아웃 했습니다.");
            return;
        }
        String id;
        int password;
        id = InputView.setId();
        password = InputView.setPassword();
        try{
            if(!userList.containsKey(id) || userList.get(id).password()!= password){
                throw new IllegalArgumentException("아이디 또는 비민번호가 존재하지 않음");
            }
            loginUser = userList.get(id);
            System.out.println("로그인 성공");
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }
}
