package service;

import dao.AccountDAO;
import model.Account;

public class ATMService {
	private AccountDAO accountDAO;

    public ATMService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public boolean validatePIN(String accountNumber, String enteredPIN) {
        Account account = accountDAO.getAccountByNumber(accountNumber);
        return account != null && account.getPin().equals(enteredPIN);
    }

    public double getAccountBalance(String accountNumber) {
        Account account = accountDAO.getAccountByNumber(accountNumber);
        return account != null ? account.getBalance() : 0.0;
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.getAccountByNumber(accountNumber);
        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            accountDAO.updateAccount(account);
        }
    }

    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.getAccountByNumber(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            accountDAO.updateAccount(account);
        }
    }
}
