package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Account;

public class AccountDAOImpl implements AccountDAO {//your_database_name?useSSL=false&user=your_username&password=your_password
    //private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Deva?useSSL=false&user=root&password=Deva%401508";
    private static final String query="CREATE TABLE IF NOT EXISTS accounts (" +"id INT AUTO_INCREMENT PRIMARY KEY," +"account_number TEXT NOT NULL," +"pin TEXT NOT NULL," +"balance DOUBLE NOT NULL)";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Deva?useSSL=false&user=root&password=Deva@1508");
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate(query);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account getAccountByNumber(String accountNumber) {
        String query = "SELECT * FROM accounts WHERE account_number = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Deva?useSSL=false&user=root&password=Deva@1508");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, accountNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Account(
                        resultSet.getInt("id"),
                        resultSet.getString("account_number"),
                        resultSet.getString("pin"),
                        resultSet.getDouble("balance")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateAccount(Account account) {
        String query = "UPDATE accounts SET balance = ? WHERE account_number = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Deva?useSSL=false&user=root&password=Deva@1508");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setString(2, account.getAccountNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
