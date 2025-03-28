package za.co.BankingSystem.Domain;

import za.co.BankingSystem.Domain.*;
import java.util.Date;

public class Account {
    // 1. Creating the Account POJO beginning with the `private` variables for
    // immutability
    private String accountNumber;
    private String accountType;
    private double balance;
    private Date dateOpened;
    private Customer customer;

    // 7.Utilizing the Builder to configure the constructor of the account
    private Account(Builder builder) {
        this.accountNumber = builder.accountNumber;
        this.accountType = builder.accountType;
        this.balance = builder.balance;
        this.dateOpened = builder.dateOpened;
        this.customer = builder.customer;
    }

    // 2. Creating a Builder inner class within the Account POJO
    public static class Builder {
        private String accountNumber;
        private String accountType;
        private double balance;
        private Date dateOpened;
        private Customer customer;

        // 3.Configuring the Contstructor of the builder with the variables of the POJO
        public Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder dateOpened(Date dateOpened) {
            this.dateOpened = dateOpened;
            return this;
        }

        public Builder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        // 4.The toString() to display the account details
        public String toString() {
            return "Account Details: {\n" +
                    "Account Number: " + accountNumber + ",\n" +
                    "Account Type: " + accountType + ",\n" +
                    "Account Balance (R): " + balance + ",\n" +
                    "Account Date Of Open: " + dateOpened + ",\n" +
                    "Customer Details: " + customer;
        }

        // 5.Declaring the copy method for the Builder class to duplicate the object
        public Builder copy(Account account) {
            this.accountNumber = accountNumber;
            this.accountType = accountType;
            this.balance = balance;
            this.dateOpened = dateOpened;
            this.customer = customer;
            return this;
        }

        // 6. The method to build/construct our POJO
        public Account build() {
            return new Account(this);
        }
    }
}