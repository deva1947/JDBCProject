package dao;

import model.Account;

public interface AccountDAO {
	 Account getAccountByNumber(String accountNumber);
	 void updateAccount(Account account);
}
