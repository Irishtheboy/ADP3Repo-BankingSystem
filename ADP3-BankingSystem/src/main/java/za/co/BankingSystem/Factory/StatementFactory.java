package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Statement;

import za.co.BankingSystem.Util.Helper;

import java.util.List;

public class StatementFactory {

    public static Statement createStatement(String statementID, String customerID, List<String> transactions, String statementDate) {
        // Validate the inputs using the helper class
        if (!Helper.validateStatement(statementID, customerID, transactions, statementDate)) {
            throw new IllegalArgumentException("Invalid data provided for Statement creation");
        }

        // If validation passes, create the Statement
        return new Statement.Builder()
                .setStatementID(statementID)
                .setCustomerID(customerID)
                .setTransaction(transactions)
                .setStatementDate(statementDate)
                .build();
    }
}
