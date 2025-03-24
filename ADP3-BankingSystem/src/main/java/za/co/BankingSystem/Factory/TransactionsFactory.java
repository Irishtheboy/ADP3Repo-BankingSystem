package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Transactions;
import za.co.BankingSystem.Util.Helper;

import java.util.Date;

public class TransactionsFactory {
    public static Transactions createTransaction(String transactionType, double amount, Account sourceAccount, Account destinationAccount) {
        // Generate unique transaction ID
        String transactionID = Helper.generateID();

        // Validate amount
        if (!Helper.isValidAmount(amount)) {
            throw new IllegalArgumentException("Transaction amount must be greater than zero");
        }

        // Ensure source account is provided
        if (sourceAccount == null) {
            throw new IllegalArgumentException("Source account cannot be null");
        }

        // Validate that a destination account is only required for transfers
        if (transactionType.equalsIgnoreCase("Transfer") && destinationAccount == null) {
            throw new IllegalArgumentException("Destination account is required for a transfer");
        }

        return new Transactions.Builder()
                .setTransactionID(transactionID)
                .setTransactionType(transactionType)
                .setAmount(amount)
                .setTransactionDate(new Date())
                .setSourceAccount(sourceAccount)
                .setDestinationAccount(destinationAccount)
                .build();
    }
}
