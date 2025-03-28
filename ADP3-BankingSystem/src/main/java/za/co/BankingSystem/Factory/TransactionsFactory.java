package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Transactions;
import za.co.BankingSystem.Util.Helper;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
/**
 * Transaction.java
 * Transaction Factory class
 *
 * Author: Franco Lukhele(222462914)
 * 28 March 2025
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
        if (Helper.isNullOrEmpty(transactionType)) {
            throw new IllegalArgumentException("Transaction type cannot be empty");
        }


        if (transactionType.equalsIgnoreCase("Withdrawal") || transactionType.equalsIgnoreCase("Transfer")) {
            if (!Helper.hasSufficientFunds(sourceAccount, amount)) {
                throw new IllegalArgumentException("Insufficient funds in the source account");
            }
        }


        Date transactionDate = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());


        Account.Builder accountBuilder = new Account.Builder().copy(sourceAccount);

        if (transactionType.equalsIgnoreCase("Deposit")) {
            sourceAccount = accountBuilder.setBalance(sourceAccount.getBalance() + amount).build();
        } else if (transactionType.equalsIgnoreCase("Withdrawal")) {
            sourceAccount = accountBuilder.setBalance(sourceAccount.getBalance() - amount).build();
        } else if (transactionType.equalsIgnoreCase("Transfer")) {

            sourceAccount = accountBuilder.setBalance(sourceAccount.getBalance() - amount).build();


            destinationAccount = new Account.Builder()
                    .copy(destinationAccount)
                    .setBalance(destinationAccount.getBalance() + amount)
                    .build();
        }


        return new Transactions.Builder()
                .setTransactionID(Helper.generateID())
                .setTransactionType(transactionType)
                .setAmount(amount)
                .setTransactionDate(transactionDate)
                .setSourceAccount(sourceAccount)
                .setDestinationAccount(destinationAccount)
                .build();
    }
}
