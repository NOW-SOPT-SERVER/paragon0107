package org.example;

import org.example.Bank.Service.Customer.Account;
import org.example.Bank.Service.Customer.UserService;

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
            System.out.println("3. BankServiceTemp");
            System.out.println("3. Exit");

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
                    System.out.println("Enter 1~3 number");
                    break;
            }

        }
    }
}
