package com.blz.jdbc.connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_Delete {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mysql", "root", "Diyuv@1808");
            Statement smt=con.createStatement();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                System.out.println("Enter Deletion Emp Id:");
                int eno=Integer.parseInt(br.readLine());
                int count= smt.executeUpdate("DELETE from emp where emp_number = " + eno);
                if (count==1)
                    System.out.println(count+"Rows Deleted");
                else
                    System.out.println("No Record Deleted");
                System.out.println("Do You Want To Delete More Records[Yes/No]");
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
