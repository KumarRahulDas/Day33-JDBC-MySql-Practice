package com.blz.BankingManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Mysql";
        String username = "root";
        String password = "Diyuv@1808";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Scanner scanner = new Scanner(System.in);

            // Get user input for the customer data
            System.out.println("Enter customer first name: ");
            String first_Name = scanner.next();
            System.out.println("Enter customer middle name: ");
            String middle_Name = scanner.next();
            System.out.println("Enter customer last name: ");
            String last_Name = scanner.next();
            System.out.println("Enter customer mob num: ");
            String mobile_number = scanner.next();

            // Prepare the SQL statement for inserting customer data
            String customerSql = "INSERT INTO Customers (id, first_name, middle_name, last_name, mobile_number) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement customerStatement = conn.prepareStatement(customerSql, Statement.RETURN_GENERATED_KEYS);
            customerStatement.setInt(1, 0);
            customerStatement.setString(2, first_Name);
            customerStatement.setString(3, middle_Name);
            customerStatement.setString(4, last_Name);
            customerStatement.setString(5, mobile_number);

            // Execute the SQL statement to insert customer data
            int customerAffectedRows = customerStatement.executeUpdate();

            // Check if the insert was successful
            if (customerAffectedRows == 0) {
                throw new SQLException("Inserting customer data failed, no rows affected.");
            }

            // Retrieve the auto-generated customer ID
            int customerId = 0;
            try (ResultSet generatedKeys = customerStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    customerId = generatedKeys.getInt(1);
                }
            }

            // Get user input for the account data
            System.out.println("Enter account number: ");
            int account_number = scanner.nextInt();
            System.out.println("Enter account type: ");
            String account_type = scanner.next();
            System.out.println("Enter account balance: ");
            double balance = scanner.nextDouble();

            // Prepare the SQL statement for inserting account data
            String accountSql = "INSERT INTO Accounts (account_number, account_type, balance, CustomerID) VALUES (?, ?, ?, ?)";
            PreparedStatement accountStatement = conn.prepareStatement(accountSql);
            accountStatement.setInt(1, account_number);
            accountStatement.setString(2, account_type);
            accountStatement.setDouble(3, balance);
            accountStatement.setInt(4, customerId);

            // Execute the SQL statement to insert account data
            int accountAffectedRows = accountStatement.executeUpdate();

            // Check if the insert was successful
            if (accountAffectedRows == 0) {
                throw new SQLException("Inserting account data failed, no rows affected.");
            }

            // Print the customer ID and account number
            System.out.println("Customer ID: " + customerId);
            System.out.println("Account number: " + account_number);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
