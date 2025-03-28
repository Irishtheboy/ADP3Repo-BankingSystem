package za.co.BankingSystem.Domain;

import java.util.List;

public class Statement {
    private String statementID;
    private String customerID;
    private List<String> transactions;
    private String statementDate;

    // Private constructor to enforce the use of Builder
    private Statement(Builder builder) {
        this.statementID = builder.statementID;
        this.customerID = builder.customerID;
        this.transactions = builder.transactions;
        this.statementDate = builder.statementDate;
    }

    // Getters
    public String getStatementID() {
        return statementID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public String getStatementDate() {
        return statementDate;
    }

    // Builder class to help construct Statement objects
    public static class Builder {
        private String statementID;
        private String customerID;
        private List<String> transactions;
        private String statementDate;

        public Builder setStatementID(String statementID) {
            this.statementID = statementID;
            return this;
        }

        public Builder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setTransaction(List<String> transactions) {
            this.transactions = transactions;
            return this;
        }

        public Builder setStatementDate(String statementDate) {
            this.statementDate = statementDate;
            return this;
        }

        // Build method to return the constructed Statement
        public Statement build() {
            return new Statement(this);
        }
    }
}
