package com.blz.jdbc.connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC_Insert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mysql", "root", "Diyuv@1808");
            PreparedStatement psmt = con.prepareStatement("INSERT INTO emp (emp_number, emp_name, emp_salary) VALUES (?, ?, ?)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                System.out.println("Enter Emp Id:");
                int eno=Integer.parseInt(br.readLine());
                System.out.println("Enter Emp Name:");
                String ename=br.readLine();
                System.out.println("Enter Emp Salary:");
                BigDecimal esal = new BigDecimal(br.readLine());
                psmt.setInt(1,eno);
                psmt.setString(2,ename);
                psmt.setBigDecimal(3,esal);
                int count= psmt.executeUpdate();
                if (count>=0)
                    System.out.println(count+"Record Inserted");
                else
                    System.out.println("Record Insertion Failed");
                System.out.println("Do You Want To Add More Records[Yes/No]");
                String ch= br.readLine();
                if(ch.equalsIgnoreCase("No"))
                    break;

            }
        }
        catch (Exception e)
        {
            System.out.println(e);

        }
    }
}
