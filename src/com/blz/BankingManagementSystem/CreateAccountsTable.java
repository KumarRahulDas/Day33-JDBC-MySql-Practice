package com.blz.BankingManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAccountsTable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Mysql";
        String username = "root";
        String password = "Diyuv@1808";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE accounts (" +
                    "id INT NOT NULL, " +
                    "account_number VARCHAR(50) NOT NULL, " +
                    "account_type VARCHAR(50) NOT NULL, " +
                    "balance DECIMAL(10,2) NOT NULL, " +
                    "branch_code VARCHAR(10) NOT NULL, " +
                    "PRIMARY KEY (id))";
            stmt.executeUpdate(sql);
            System.out.println("Accounts table created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating accounts table: " + e.getMessage());
        }
    }
}
