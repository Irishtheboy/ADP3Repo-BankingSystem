package za.co.BankingSystem.Domain;

import java.util.Date;

/**
 * Transactions class representing transactions in the system.
 * This class uses the Builder pattern for constructing Transaction objects.
 *
 * Author: Franco Lukhele
 */
public class Transactions {
    private final String transactionID;
    private final String transactionType;
    private final double amount;
    private final Date transactionDate;
    private final Account sourceAccount;
    private final Account destinationAccount; // Optional for transfers

    private Transactions(Builder builder) {
        this.transactionID = builder.transactionID;
        this.transactionType = builder.transactionType;
        this.amount = builder.amount;
        this.transactionDate = builder.transactionDate;
        this.sourceAccount = builder.sourceAccount;
        this.destinationAccount = builder.destinationAccount;
    }

    public static class Builder {
        private String transactionID;
        private String transactionType;
        private double amount;
        private Date transactionDate;
        private Account sourceAccount;
        private Account destinationAccount; // Optional for transfers

        public Builder setTransactionID(String transactionID) {
            this.transactionID = transactionID;
            return this;
        }

        public Builder setTransactionType(String transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setTransactionDate(Date transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }

        public Builder setSourceAccount(Account sourceAccount) {
            this.sourceAccount = sourceAccount;
            return this;
        }

        public Builder setDestinationAccount(Account destinationAccount) {
            this.destinationAccount = destinationAccount;
            return this;
        }

        public Transactions build() {
            return new Transactions(this);
        }
    }

    public String getTransactionID() { return transactionID; }
    public String getTransactionType() { return transactionType; }
    public double getAmount() { return amount; }
    public Date getTransactionDate() { return transactionDate; }
    public Account getSourceAccount() { return sourceAccount; }
    public Account getDestinationAccount() { return destinationAccount; }
}
