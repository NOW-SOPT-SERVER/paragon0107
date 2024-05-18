package org.example.Control;

import java.util.ArrayList;
import java.util.Arrays;
import org.example.Repogitory.UserRepository;
import org.example.Service.BankService;

import java.util.Scanner;
import org.example.Service.BankServiceInterface;
import org.example.View.InputView;

public class BankControl {
    private static  BankService bankService;
    private static UserRepository userRepository;
    private BankControl(){
        bankService = BankService.getInstance();
        userRepository = UserRepository.getInstance();
    };
    public static BankControl getInstance(){
        return bankControl;
    }

    private final Scanner scanner = new Scanner(System.in);

    private static final BankControl bankControl = new BankControl();
    private enum Menu{
        REGISTER(1, userRepository::addUser),
        LOGIN(2,userRepository::loginOrLogout),
        START_BANK_SERVICE(3,bankService::startBank),
        Quit_Program(4,bankService::quit)
        ;
        final Runnable option;
        final int index;
        Menu(int i, Runnable run) {
            this.option = run;
            this.index =i;
        }
        public void run() {
            option.run();
        }
        public int getIndex() {
            return index;
        }
    }
    public void startBank(){
        while (true){
            int choice = InputView.getMenuOption();
            try{
               Arrays.stream(Menu.values())
                        .filter(index -> index.getIndex() == choice)
                        .forEach(Menu::run);
            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException("숫자입력해사요");
            }

        }
    }

}
