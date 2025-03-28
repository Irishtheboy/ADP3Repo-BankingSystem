package za.co.BankingSystem.Util;

import za.co.BankingSystem.Domain.Account;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {


    public static String generateID() {
        return UUID.randomUUID().toString();
    }


    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }


    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{10,15}");
    }


    public static boolean isNullOrEmpty(String value) {
        return value == null  || value.trim().isEmpty();
    }


    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }


    public static boolean isValidTransactionType(String transactionType) {
        return transactionType != null && (
                transactionType.equalsIgnoreCase("Deposit") ||
                        transactionType.equalsIgnoreCase("Withdrawal") ||
                        transactionType.equalsIgnoreCase("Transfer")
        );
    }


    public static boolean isValidTransfer(Account sourceAccount, Account destinationAccount) {
        return destinationAccount != null && !sourceAccount.getAccountNumber().equals(destinationAccount.getAccountNumber());
    }


    public static boolean hasSufficientFunds(Account sourceAccount, double amount) {
        return sourceAccount.getBalance() >= amount;
    }

    public static boolean validateStatement(String statementID, String customerID, List<String> transactions, String statementDate) {


        

        if (statementID == null || statementID.isEmpty()) {
            return false;
        }
        if (customerID == null || customerID.isEmpty()) {
            return false;
        }
        if (transactions == null || transactions.isEmpty()) {
            return false;
        }
        if (statementDate == null || statementDate.isEmpty()) {
            return false;
        }

        return true;
    }

}
