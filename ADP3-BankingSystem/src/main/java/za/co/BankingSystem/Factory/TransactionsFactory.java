package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Transactions;
import za.co.BankingSystem.Util.Helper;

import java.util.Date;

/**
 * Factory class for creating Transactions objects.
 * Validations are handled in Helper class.
 */
public class TransactionsFactory {

    public static Transactions createTransaction(String transactionType, double amount, Account sourceAccount, Account destinationAccount) {
        if (!Helper.isValidTransactionType(transactionType)) {
            throw new IllegalArgumentException("Invalid transaction type");
        }

        if (!Helper.isValidAmount(amount)) {
            throw new IllegalArgumentException("Transaction amount must be greater than zero");
        }

        if (sourceAccount == null) {
            throw new IllegalArgumentException("Source account cannot be null");
        }

        if (transactionType.equalsIgnoreCase("Transfer")) {
            if (!Helper.isValidTransfer(sourceAccount, destinationAccount)) {
                throw new IllegalArgumentException("Invalid transfer: Destination account required and must be different");
            }
        }

        if (transactionType.equalsIgnoreCase("Withdrawal") || transactionType.equalsIgnoreCase("Transfer")) {
            if (!Helper.hasSufficientFunds(sourceAccount, amount)) {
                throw new IllegalArgumentException("Insufficient funds in the source account");
            }
        }

        // Update balances using the Builder pattern
        if (transactionType.equalsIgnoreCase("Deposit")) {
            sourceAccount = new Account.Builder()
                    .copy(sourceAccount)
                    .setBalance(sourceAccount.getBalance() + amount)
                    .build();
        } else if (transactionType.equalsIgnoreCase("Withdrawal")) {
            sourceAccount = new Account.Builder()
                    .copy(sourceAccount)
                    .setBalance(sourceAccount.getBalance() - amount)
                    .build();
        } else if (transactionType.equalsIgnoreCase("Transfer")) {
            sourceAccount = new Account.Builder()
                    .copy(sourceAccount)
                    .setBalance(sourceAccount.getBalance() - amount)
                    .build();

            destinationAccount = new Account.Builder()
                    .copy(destinationAccount)
                    .setBalance(destinationAccount.getBalance() + amount)
                    .build();
        }


        return new Transactions.Builder()
                .setTransactionID(Helper.generateID())
                .setTransactionType(transactionType)
                .setAmount(amount)
                .setTransactionDate(new Date())
                .setSourceAccount(sourceAccount)
                .setDestinationAccount(destinationAccount)
                .build();
    }
}
