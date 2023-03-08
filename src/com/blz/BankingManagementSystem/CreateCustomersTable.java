package com.blz.BankingManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateCustomersTable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Mysql";
        String username = "root";
        String password = "Diyuv@1808";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE customers (" +
                    "id INT NOT NULL, " +
                    "first_name VARCHAR(50) NOT NULL, " +
                    "middle_name VARCHAR(50), " +
                    "last_name VARCHAR(50) NOT NULL, " +
                    "mobile_number VARCHAR(20) NOT NULL, " +
                    "PRIMARY KEY (id))";
            stmt.executeUpdate(sql);
            System.out.println("Customers table created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating customers table: " + e.getMessage());
        }
    }
}
