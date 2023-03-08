package com.blz.jdbc.connection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_Select {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mysql", "root", "Diyuv@1808");
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("SELECT * FROM emp");
            while (rs.next()) {
                int eno = rs.getInt(1);
                String ename = rs.getString(2);
                BigDecimal esal = rs.getBigDecimal(3);
                System.out.println("Emp Num:" + eno);
                System.out.println("Emp Name:" + ename);
                System.out.println("Emp Salary:" + esal);
                System.out.println("\n");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        }
    }

