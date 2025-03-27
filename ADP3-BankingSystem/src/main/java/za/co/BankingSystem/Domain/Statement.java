package za.co.BankingSystem.Domain;

import java.util.List;

public class Statement {
    private String statementID;
    private String customerID;
    private List<String> transaction;
    private String statementDate;

    private Statement (Builder builder){
        this.statementID = builder.statementID;
        this.customerID = builder.customerID;
        this.transaction = builder.transaction;
        this.statementDate = builder.statementDate;
    }


    public String getStatementID() {
        return statementID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public List<String> getTransaction() {
        return transaction;
    }

    public String getStatementDate() {
        return statementDate;
    }

    @Override
    public String toString() {
        return "Statement: " +
                "statementID='" + statementID + '\'' +
                ", customerID='" + customerID + '\'' +
                ", transaction=" + transaction +
                ", statementDate='" + statementDate + '\'' +
                '}';
    }

    public static class Builder {
        private String statementID;
        private String customerID;
        private List<String> transaction;
        private String statementDate;

        public Builder setStatementID(String statementID) {
            this.statementID = statementID;
            return this;
        }
        public Builder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }
        public Builder setTransaction(List<String> transaction) {
            this.transaction = transaction;
            return this;
        }
        public Builder setStatementDate(String statementDate) {
            this.statementDate = statementDate;
            return this;
        }
        public Statement build() {
            return new Statement(this);
        }
    }
}
