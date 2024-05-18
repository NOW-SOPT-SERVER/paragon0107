package org.example.Service;


public class BankService {
    private static final BankService bankService = new BankService();
    public static BankService getInstance(){
        return bankService;
    }
    public void startBank(){
        System.out.println("스타트뱅크");
    }
    public void quit(){
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }
}
