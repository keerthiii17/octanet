package com.atmproj;//package declaration
import java.util.Scanner;
public class MainClass {
    private static final int ATMNUMBER = 12345;//predefined initial value of atmnumber
    private static final int ATM_PIN = 123;//predefined initial value pin
    public static void main(String[] args) {
        Atmopimpl op = new Atmopimpl();//object creation of Atmopimpl
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the ATM Machine!");
            System.out.print("Enter ATM Number: ");
            int atmNumber = scanner.nextInt();
            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();
            //validating user credentials
            if (ATMNUMBER == atmNumber && ATM_PIN == pin) {
                while (true) {
                    System.out.println("\n1. View Balance\n2. Withdraw Amount\n3. Deposit Amount\n4. View Mini Statement\n5. Change PIN\n6. Exit");//menu
                    System.out.print("Enter Choice: ");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> op.viewBalance();
                        case 2 ->  {
                            System.out.print("Enter amount to withdraw: ");
                            double amount = scanner.nextDouble();
                            op.withdrawAmount(amount);
                            }
                        case 3 ->  {
                            System.out.print("Enter amount to deposit: ");
                            double amount = scanner.nextDouble();
                            op.depositAmount(amount);
                            }
                        case 4 -> op.viewMiniStatement();
                        case 5 ->  {
                            System.out.print("Enter new PIN: ");
                            int newPin = scanner.nextInt();
                            op.changePin(newPin);
                            }
                        case 6 ->  {
                            System.out.println("Thank you for using the ATM Machine. Goodbye!");
                            System.exit(0);
                            }
                        default ->  {
                            System.out.println("Invalid choice. Please try again.");//to handle invalid choice
                            }
                        }
                        
                }
            } else {
                System.out.println("Incorrect ATM Number or PIN.");//to display error for invalid credentials
            }
        }
    }
}

