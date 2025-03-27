package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Statement;

import java.util.List;

public class StatementFactory {
    public static Statement createStatement(String statementID, String customerID, List<String> transactions, String statementDate) {
        return new Statement.Builder()
                .setStatementID(statementID)
                .setCustomerID(customerID)
                .setTransaction(transactions)
                .setStatementDate(statementDate)
                .build();
    }
}
