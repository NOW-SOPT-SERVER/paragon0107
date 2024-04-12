package org.example.Control;

import org.example.Repogitory.UserRepository;
import org.example.Service.BankService;
import org.example.View.InputView;

import java.util.Scanner;

public class BankControl {

    private final int REGISTER = 1;
    private final int LOGIN = 2;
    private final int START_BANK_SERVICE = 3;
    private final int END_SERVICE = 4;

    private final Scanner scanner = new Scanner(System.in);
    private static final BankControl bankControl = new BankControl();
    private final BankService bankService = BankService.getInstance();
    private final UserRepository userRepository = UserRepository.getInstance();

    private static BankControl getInstance(){
        return bankControl;
    }

    public void startBank(){

        boolean running = true;
        while (running){
            int choice = InputView.getMenuOption();

            try{
                if(choice == REGISTER){
                    userRepository.addUser();
                }
                if(choice == LOGIN){
                    userRepository.login();
                }if(choice == START_BANK_SERVICE){
                    bankService.startBank();
                }if(choice == END_SERVICE){
                    running = false;
                }
            }catch (IllegalArgumentException e){
                System.out.println(e);
            }

        }
    }
}
