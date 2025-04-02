/*Customer.java
Customer POJO class
Author: Naqeebah Khan(219099073)
date: 24th March 2025*/
package za.co.BankingSystem.Domain;

import java.util.List;
import za.co.BankingSystem.Domain.Account;

public class Customer{
    private String customerID;
    private String customerName;
    private String customerSurname;
    private String customerAddress;
    private String customerEmail;
    private String phoneNumber;
    private List<Account> accounts;

    private Customer(Builder builder){
        this.customerID = builder.customerID;
        this.customerName = builder.customerName;
        this.customerSurname = builder.customerSurname;
        this.customerAddress = builder.customerAddress;
        this.customerEmail = builder.customerEmail;
        this.phoneNumber = builder.phoneNumber;
        this.accounts = builder.accounts;

    }

    public String getCustomerID(){
        return customerID;
    }

    public String getCustomerName(){
        return customerName;
    }

    public String getCustomerSurname(){
        return customerSurname;
    }

    public String getCustomerAddress(){
        return customerAddress;
    }

    public String getCustomerEmail(){
        return customerEmail;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    @Override
    public String toString() {
        return "Customer: " +
                "Customer ID ='" + customerID + '\'' +
                ", Name ='" + customerName + '\'' +
                ", Surname ='" + customerSurname + '\'' +
                ", Address ='" + customerAddress + '\'' +
                ", Email ='" + customerEmail + '\'' +
                ", Phone Number ='" + phoneNumber + '\'' +
                ", Accounts =" + accounts +
                '}';
    }


    public static class Builder{
        private String customerID;
        private String customerName;
        private String customerSurname;
        private String customerAddress;
        private String customerEmail;
        private String phoneNumber;
        private List<Account> accounts;

        public Builder setCustomerID(String customerID){
            this.customerID = customerID;
            return this;
        }

        public Builder setCustomerName(String customerName){
            this.customerName = customerName;
            return this;
        }

        public Builder setCustomerSurname(String customerSurname){
            this.customerSurname = customerSurname;
            return this;
        }

        public Builder setCustomerAddress(String customerAddress){
            this.customerAddress = customerAddress;
            return this;
        }

        public Builder setCustomerEmail(String customerEmail){
            this.customerEmail = customerEmail;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setAccounts(List<Account> accounts){
            this.accounts = accounts;
            return this;
        }

        public Builder copy(Customer customer){
            this.customerID = customer.getCustomerID();
            this.customerName = customer.getCustomerName();
            this.customerSurname = customer.getCustomerSurname();
            this.customerAddress = customer.getCustomerAddress();
            this.customerEmail = customer.getCustomerEmail();
            this.phoneNumber = customer.getPhoneNumber();
            this.accounts = customer.getAccounts();
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }
}
