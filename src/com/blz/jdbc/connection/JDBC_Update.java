package com.blz.jdbc.connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;



public class JDBC_Update {
    public static void main(String[] args) {
        String value;
        int eno;
        BigDecimal esal;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mysql", "root", "Diyuv@1808");
            Statement smt = con.createStatement();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter Emp Id:");
                value =br.readLine();
                eno=Integer.parseInt(value);
                System.out.println("Enter Emp Salary:");
                value = br.readLine();
                esal = new BigDecimal(value);
                int count= smt.executeUpdate("UPDATE emp SET emp_salary = " + esal + " WHERE emp_number = " + eno);
                if (count>0)
                    System.out.println(count+"Row Updated");
                else
                    System.out.println("No Record Found");


            }
        catch (Exception e)
        {
            System.out.println(e);

        }
    }
}
