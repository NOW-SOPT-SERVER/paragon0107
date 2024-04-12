package org.example.Service;

import org.example.Bank.Service.BankServiceTemp;

public class BankService {
    private static final BankService bankService = new BankService();
    public static BankService getInstance(){
        return bankService;
    }
    public void startBank(){

    }
}
