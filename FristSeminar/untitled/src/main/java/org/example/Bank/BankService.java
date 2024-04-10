package org.example.Bank;

import org.example.Customer.Account;

import java.util.HashMap;
import java.util.Scanner;

public class BankService {
    Account account;
    HashMap<Integer,Account> userList;

    static final Scanner scanner = new Scanner(System.in);
    public BankService(Account account,HashMap<Integer,Account> userList){
        this.account = account;
        this.userList = userList;
    }
    public void startBank(){

        boolean power = true;
        while (power){
            System.out.println("----ATM----");
            System.out.println("0. Check balance");
            System.out.println("1. deposit");
            System.out.println("2. withdraw");
            System.out.println("3. transfer");
            System.out.println("4. Exit");
            System.out.println("-----------");

            int service = scanner.nextInt();


            switch (service) {
                case 0:
                    System.out.println("Current balance is " +account.getBalance()+"won");
                    break;
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    transfer();
                    break;
                case 4:
                    power = false;
                    this.account= null;
                    break;
                default:
                    System.out.println("Enter 1~4");
                    break;
            }
        }

    }

    public void deposit(){
        System.out.println("How much would you like to deposit?");
        int money = scanner.nextInt();

        account.setBalance(account.getBalance() + money);
        System.out.println("Current balance is  " +account.getBalance()+"won");
    }
    public void withdraw(){
        System.out.println("How much would you like to withdraw?");
        int money = scanner.nextInt();

        if(account.getBalance() >= money){
            account.setBalance(account.getBalance()-money);
        }else {
            System.out.println("There is not enough balance.");
        }
        System.out.println("Current balance is  " +account.getBalance()+"won");
    }
    public void transfer(){
        System.out.println("Please enter your ID to transfer money");
        String peerId = scanner.next();
        System.out.println("Please enter the money to be transferred");
        int money = scanner.nextInt();

        for(Account peer : userList.values()){
            if(peer.getId().equals(peerId)){
                peer.setBalance(peer.getBalance() + money);
                System.out.println("Success");
                return;
            }
        }
        System.out.println("ID does not exist.");
        return;
    }

}
