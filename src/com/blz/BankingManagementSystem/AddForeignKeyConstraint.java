package com.blz.BankingManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddForeignKeyConstraint {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Mysql";
        String username = "root";
        String password = "Diyuv@1808";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {
            String sql = "ALTER TABLE accounts " +
                    "ADD CONSTRAINT FK_customers_accounts " +
                    "FOREIGN KEY (id) REFERENCES customers(id)";
            stmt.executeUpdate(sql);
            System.out.println("Foreign key constraint added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding foreign key constraint: " + e.getMessage());
        }
    }
}
