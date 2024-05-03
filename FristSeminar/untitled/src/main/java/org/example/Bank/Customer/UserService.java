//package org.example.Bank.Customer;
//
//import java.util.*;
//
//public class UserService {
//    static int number = 1;
//    static HashMap<Integer, org.example.Bank.Service.Customer.Account> userList = new HashMap<>();
//    Account loginAccount = null;
//    static Scanner scanner = new Scanner(System.in);
//    public void createAccount(){
//        String name;
//        String  id;
//        int pwd;
//        System.out.println("Enter name");
//        name = scanner.next();
//        System.out.println("Enter id");
//        id = scanner.next();
//        System.out.println("Enter password");
//        pwd = scanner.nextInt();
//        userList.put(number,new Account(name,id,pwd)) ;
//        number += 1;
//
//        System.out.println("Success");
//        for (Map.Entry<Integer, Account> entry : userList.entrySet()) {
//            Account temp =entry.getValue();
//            System.out.println("Key: " + entry.getKey() + ", id: " + temp.getId()+" pwd: " + temp.getPassword());
//        }
//    }
//    public void login(){
//        System.out.println(userList.get(2).getId()+ userList.get(2).getPassword());
//        String id;
//        int pwd;
//        System.out.println("Enter id");
//        id = scanner.next();
//        System.out.println("Enter password");
//        pwd =scanner.nextInt();
//        for(Account account : userList.values()){
//            System.out.println(account.getId());
//            if(account.getId().equals(id)){
//                System.out.println(account.getPassword());
//                if(account.getPassword() == pwd){
//                    System.out.println("Success");
//                    loginAccount = account;
//                    return;
//                }
//            }
//        }
//        System.out.println("Fail");
//        return;
//    }
//    public void startBank(){
//        if(loginAccount == null){
//            System.out.println("Do login");
//            return;
//        }
//        BankServiceTemp bankServiceTemp = new BankServiceTemp(loginAccount,userList);
//        bankServiceTemp.startBank();
//        loginAccount =null;
//    }
//
//}
