package view;
import java.util.Scanner;
import service.ATMService;
import dao.AccountDAO;
import dao.AccountDAOImpl;
public class ATMApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AccountDAO accountDAO = new AccountDAOImpl();
        ATMService atmService = new ATMService(accountDAO);
        ATMView atmView = new ATMView();

        // Main ATM application logic
        String accountNumber = atmView.getAccountNumberFromUser();
        String pin = atmView.getPINFromUser();

        if (atmService.validatePIN(accountNumber, pin)) {
            //atmView.displayBalance(atmService.getAccountBalance(accountNumber));
        	System.out.println("Welcome");
        	int option;
            do {
            	atmView.printOptions();
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter the deposit amount: ");
                        double depositAmount = atmView.getAmountFromUser();
                        atmService.deposit(accountNumber, depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter the withdrawal amount: ");
                        double withdrawalAmount = atmView.getAmountFromUser();
                        atmService.withdraw(accountNumber, withdrawalAmount);
                        break;
                    case 3:
                    	atmView.displayBalance(atmService.getAccountBalance(accountNumber));
                        //System.out.println("Current balance: " + balance);
                        break;
                }
            } while (option != 4);
            System.out.println("Thank you for using our ATM.");
            

            //atmView.displayBalance(atmService.getAccountBalance(accountNumber));
        } else {
            atmView.displayMessage("Invalid account number or PIN.");
        }
    }
	}


