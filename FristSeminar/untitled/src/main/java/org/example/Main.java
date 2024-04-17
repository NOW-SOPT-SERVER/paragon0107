package org.example;

import org.example.Control.BankControl;

public class Main {

    public static void main(String[] args) {
        BankControl bankControl = BankControl.getInstance();
        bankControl.startBank();
    }
}
