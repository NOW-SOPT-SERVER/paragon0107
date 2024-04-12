package org.example.View;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    public static int getMenuOption(){
        System.out.println("-------솝트뱅크-------");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("3. 은행서비스");
        System.out.println("4. 종료");
        return scanner.nextInt();
    }
}
