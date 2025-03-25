//Naqeebah Khan 219099073
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

    private Customer(Builder builder){
        this.customerID = builder.customerID;
        this.customerName = builder.customerName;
        this.customerSurname = builder.customerSurname;
        this.customerAddress = builder.customerAddress;
        this.customerEmail = builder.customerEmail;
        this.phoneNumber = builder.phoneNumber;
    }

    public String getCustomerID(){
        return customerID;
    }

    public String getCustomerName(){


    public String getcustomerName(){

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

    public String getcustomerAddress(){
        return customerAddress;
    }
    public String getcustomerEmail(){
        return customerEmail;
    }
    public String getphoneNumber(){

        return phoneNumber;
    }


    @Override
    public String toString() {
        return "Customer: " +
                "Customer ID='" + customerID + '\'' +
                ", Name='" + customerName + '\'' +
                ", Surname='" + customerSurname + '\'' +
                ", Address='" + customerAddress + '\'' +
                ", Email='" + customerEmail + '\'' +
                ", Phone Number='" + phoneNumber + '\'' +
                ", Accounts=" + accounts +

    @java.lang.Override
    public java.lang.String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerSurname='" + customerSurname + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +

                '}';
    }

    //builder//
    public static class Builder{
        private String customerID;
        private String customerName;
        private String customerSurname;
        private String customerAddress;
        private String customerEmail;
        private String phoneNumber;

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
        public Customer build(){
            return new Customer(this);
        }


    }
}