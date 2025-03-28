package za.co.BankingSystem.Domain;

import java.util.Date;

public class Account {

    private final String accountNumber;
    private final String accountType;
    private final double balance;
    private final Date dateOpened;
    private final Customer customer;


    private Account(Builder builder) {
        this.accountNumber = builder.accountNumber;
        this.accountType = builder.accountType;
        this.balance = builder.balance;
        this.dateOpened = builder.dateOpened;
        this.customer = builder.customer;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public Date getDateOpened() {
        return dateOpened;
    }

    public Customer getCustomer() {
        return customer;
    }

    //  Builder Class
    public static class Builder {
        private String accountNumber;
        private String accountType;
        private double balance;
        private Date dateOpened;
        private Customer customer;

        public Builder setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setAccountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder setBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder setDateOpened(Date dateOpened) {
            this.dateOpened = dateOpened;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        //I had to fix the copy because it was placed in the incorrect spot
        //  Corrected copy method
        public Builder copy(Account account) {
            this.accountNumber = account.accountNumber;
            this.accountType = account.accountType;
            this.balance = account.balance;
            this.dateOpened = account.dateOpened;
            this.customer = account.customer;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }


    @Override
    public String toString() {
        return "Account {" +
                "Account Number='" + accountNumber + '\'' +
                ", Account Type='" + accountType + '\'' +
                ", Balance=R" + balance +
                ", Date Opened=" + dateOpened +
                ", Customer=" + (customer != null ? customer.toString() : "No Customer Linked") +
                '}';
    }


}
