package za.co.BankingSystem.Domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String bankName;
    private String bankID;
    private String address;
    private String contactNumber;
    private List<Customer> customers;
    private List<Account> accounts;

    private Bank() {
    }

    private Bank(Builder builder) {
        this.bankName = builder.bankName;
        this.bankID = builder.bankID;
        this.address = builder.address;
        this.contactNumber = builder.contactNumber;
        this.customers = builder.customers;
        this.accounts = builder.accounts;
    }


    public String getBankName() {
        return bankName;
    }

    public String getBankID() {
        return bankID;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", bankID='" + bankID + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", customers=" + customers +
                ", accounts=" + accounts +
                '}';
    }

    public static class Builder {
        private String bankName;
        private String bankID;
        private String address;
        private String contactNumber;
        private List<Customer> customers = new ArrayList<>();
        private List<Account> accounts = new ArrayList<>();


        public Builder setBankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public Builder setBankID(String bankID) {
            this.bankID = bankID;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder setCustomers(List<Customer> customers) {
            this.customers = customers;
            return this;
        }

        public Builder setAccounts(List<Account> accounts) {
            this.accounts = accounts;
            return this;
        }

        public Builder copy(Bank bank) {
            this.bankName = bank.bankName;
            this.bankID = bank.bankID;
            this.address = bank.address;
            this.contactNumber = bank.contactNumber;
            this.customers = bank.customers;
            this.accounts = bank.accounts;
            return this;
        }

        public Bank build() {
            return new Bank(this);
        }
    }
}


