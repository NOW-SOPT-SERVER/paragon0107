package org.example.View;

import java.util.Scanner;
import org.example.DTO.User;
import org.example.Repogitory.UserRepository;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getMenuOption() {
        User loginUser = UserRepository.getInstance().loginUser;
        System.out.println("-------솝트뱅크-------");
        if(loginUser!=null){
            System.out.println("현제접속 유저: "+ loginUser.name());
        }
        System.out.println("1. 회원가입");
        System.out.println(loginUser == null? "2. 로그인" : "2. 로그아웃");
        System.out.println("3. 은행서비스");
        System.out.println("4. 종료");
        int choice;
        while (true) {
            choice = scanner.nextInt();
            if (choice >= 1 && choice <= 4)
                return choice;
            System.out.println("1 ~ 4 사이의 수를 입력하세요");
        }
    }
    public static void createUser(){
        System.out.println("-------유저추가-------");
    }
    public static String setId(){
        System.out.print("아이디: ");
        return scanner.next();
    }
    public static String setName(){
        System.out.print("이름: ");
        return scanner.next();
    }
    public static int setPassword(){
        System.out.print("비밀번호(숫자만 입력하세요): ");
        return  scanner.nextInt();
    }

}



