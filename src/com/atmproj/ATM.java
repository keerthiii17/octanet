package com.atmproj;//package declaration

public class ATM {
    private double balance;
    //default constructor 
    public ATM() {
        this.balance = 0.0;
    }
    //to get current balance
    public double getBalance() {
        return balance;
    }
    //update balance after deposit and withdraw
    public void updateBalance(double amount) {
        this.balance += amount;
    }
}

