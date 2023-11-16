package model;

public class Account {
	private int accountId;
    private String accountNumber;
    private String pin;
    private double balance;

    public Account(int accountId, String accountNumber, String pin, double balance) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", pin=" + pin + ", balance="
				+ balance + "]";
	}
}
