package view;

import java.util.Scanner;

public class ATMView {
	private Scanner scanner = new Scanner(System.in);

    public String getAccountNumberFromUser() {
        System.out.print("Enter account number: ");
        return scanner.nextLine();
    }

    public String getPINFromUser() {
        System.out.print("Enter PIN: ");
        return scanner.nextLine();
    }

    public double getAmountFromUser() {
        System.out.print("Enter amount: ");
        return scanner.nextDouble();
    }

    public void displayBalance(double balance) {
        System.out.println("Current balance: $" + balance);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
    public void printOptions() {
        System.out.println("Please choose from one of the following options:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check balance");
        System.out.println("4. Exit");
    }
}
