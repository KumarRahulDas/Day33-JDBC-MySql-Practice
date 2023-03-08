package com.blz.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_Connect {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mysql", "root", "Diyuv@1808");
            Statement smt = con.createStatement();
            smt.executeUpdate("CREATE TABLE emp (emp_number INT, emp_name VARCHAR(50), emp_salary DECIMAL(10,2))");

            System.out.println("Table Created Succesfully");
            con.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }
}
