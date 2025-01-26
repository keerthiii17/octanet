package com.atmproj;//package declaration
import java.util.LinkedHashMap;//using linkedhashmap for ministatement
import java.util.Map;//to declare ministmt as Map<Double, String>

//class to implement AtmOperation interface
public class Atmopimpl implements AtmOperation {
    private final ATM atm = new ATM();//objet of ATM class
    private final Map<Double, String> ministmt = new LinkedHashMap<>();//to store transaction details 
    private int atmPin = 123;//current pin
    //to change pin
    public void changePin(int newPin) {
        this.atmPin = newPin;
        ministmt.put(0.0, "PIN Changed Successfully");
        System.out.println("PIN changed successfully.");
    }
    //to view current balance
    @Override
    public void viewBalance() {
        System.out.println("Available Balance: " + atm.getBalance());
    }

    @Override
    public void withdrawAmount(double amount) {
        if (amount % 500 != 0) //checks that the amount is in multiples of 500
        {
            System.out.println("Please enter the amount in multiples of 500.");
        } else if (amount > atm.getBalance()) {
            System.out.println("Insufficient balance.");
        } else {
            atm.updateBalance(-amount);
            ministmt.put(amount, "Amount Withdrawn");
            System.out.println("Collect the cash: " + amount);
            viewBalance();
        }
    }

    @Override
    public void depositAmount(double amount) {
        atm.updateBalance(amount);
        ministmt.put(amount, "Amount Deposited");
        System.out.println(amount + " deposited successfully.");
        viewBalance();
    }
    //to display ministatement of the accoount
    @Override
    public void viewMiniStatement() {
        if (ministmt.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            ministmt.forEach((k, v) -> System.out.println(k + " - " + v));
        }
    }
    //to retrieve the current pin
    public int getAtmPin() {
        return atmPin;
    }
}

