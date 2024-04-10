package org.example;

import org.example.Customer.Account;
import org.example.Customer.UserService;

import java.util.Scanner;

public class Main {

    Account loginAccount;

    public static void main(String[] args) {
        boolean power = true;
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();

        while (power) {
            System.out.println("1. CreateUSer");
            System.out.println("2. login");
            System.out.println("3. BankService");
            System.out.println("4. Exit");

            int service = scanner.nextInt();
            switch (service) {
                case 1:
                    userService.createAccount();
                    break;
                case 2:
                    userService.login();
                    break;

                case 3:
                    userService.startBank();
                    break;
                case 4:
                    power = false;
                    break;
                default:
                    System.out.println("1~3 사이의 수를 입력해 주세요.");
                    break;
            }

        }
    }
}
