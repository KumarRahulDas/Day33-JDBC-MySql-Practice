package com.blz.BankingManagementSystem;

public class Account {
    private int id;
    private String accountNumber;
    private String accountType;
    private double balance;
    private String branchCode;

    // Constructor
    public Account(int id, String accountNumber, String accountType, double balance, String branchCode) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.branchCode = branchCode;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    // Deposit operation
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposit of " + amount + " successful. New balance is: " + this.balance);
    }

    // Withdraw operation
    public void withdraw(double amount) {
        if (this.balance < amount) {
            System.out.println("Insufficient funds. Withdrawal of " + amount + " failed.");
        } else {
            this.balance -= amount;
            System.out.println("Withdrawal of " + amount + " successful. New balance is: " + this.balance);
        }
    }
}
