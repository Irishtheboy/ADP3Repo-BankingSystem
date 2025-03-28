package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Transactions;
import za.co.BankingSystem.Util.Helper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TransactionsFactory {

    public static Transactions createTransaction(String transactionType, double amount, Account sourceAccount, Account destinationAccount) {
        // Validate transaction type
        if (!Helper.isValidTransactionType(transactionType)) {
            throw new IllegalArgumentException("Invalid transaction type");
        }

        // Validate transaction amount
        if (!Helper.isValidAmount(amount)) {
            throw new IllegalArgumentException("Transaction amount must be greater than zero");
        }

        // Validate source account
        if (sourceAccount == null) {
            throw new IllegalArgumentException("Source account cannot be null");
        }

        // Handle transfer-specific validation
        if (transactionType.equalsIgnoreCase("Transfer")) {
            if (!Helper.isValidTransfer(sourceAccount, destinationAccount)) {
                throw new IllegalArgumentException("Invalid transfer: Destination account required and must be different");
            }
        }
        if (Helper.isNullOrEmpty(transactionType)) {  // Check for empty transaction type
            throw new IllegalArgumentException("Transaction type cannot be empty");
        }

        // Check for sufficient funds for withdrawal or transfer
        if (transactionType.equalsIgnoreCase("Withdrawal") || transactionType.equalsIgnoreCase("Transfer")) {
            if (!Helper.hasSufficientFunds(sourceAccount, amount)) {
                throw new IllegalArgumentException("Insufficient funds in the source account");
            }
        }

        // Convert LocalDateTime to Date for transaction timestamp
        Date transactionDate = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());

        // Update account balances based on transaction type
        Account.Builder accountBuilder = new Account.Builder().copy(sourceAccount);

        if (transactionType.equalsIgnoreCase("Deposit")) {
            sourceAccount = accountBuilder.setBalance(sourceAccount.getBalance() + amount).build();
        } else if (transactionType.equalsIgnoreCase("Withdrawal")) {
            sourceAccount = accountBuilder.setBalance(sourceAccount.getBalance() - amount).build();
        } else if (transactionType.equalsIgnoreCase("Transfer")) {
            // Update source account balance for transfer
            sourceAccount = accountBuilder.setBalance(sourceAccount.getBalance() - amount).build();

            // Update destination account balance for transfer
            destinationAccount = new Account.Builder()
                    .copy(destinationAccount)
                    .setBalance(destinationAccount.getBalance() + amount)
                    .build();
        }

        // Create and return the transaction
        return new Transactions.Builder()
                .setTransactionID(Helper.generateID())
                .setTransactionType(transactionType)
                .setAmount(amount)
                .setTransactionDate(transactionDate)  // Using Date for transaction date
                .setSourceAccount(sourceAccount)
                .setDestinationAccount(destinationAccount)
                .build();
    }
}
