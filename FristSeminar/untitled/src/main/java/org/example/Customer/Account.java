package org.example.Customer;

public class Account {
    String name;
    String id;
    int password;
    int balance =0;

    public Account(String name, String id, int password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getPassword() {
        return password;
    }

    public int getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setBalance(int balance) {
        this.balance = balance;

    }
}
