package za.co.BankingSystem.Util;

import za.co.BankingSystem.Domain.Account;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {

    // Generate a unique identifier
    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    // Validate email format using regex
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }

    // Validate phone number (basic check for digits and length)
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{10,15}");
    }

    // Validate non-empty strings
    public static boolean isNullOrEmpty(String value) {
        return value == null  || value.trim().isEmpty();
    }

    // Check if an amount is valid (greater than zero)
    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    // Validate transaction type
    public static boolean isValidTransactionType(String transactionType) {
        return transactionType != null && (
                transactionType.equalsIgnoreCase("Deposit") ||
                        transactionType.equalsIgnoreCase("Withdrawal") ||
                        transactionType.equalsIgnoreCase("Transfer")
        );
    }

    // Validate transfer between accounts
    public static boolean isValidTransfer(Account sourceAccount, Account destinationAccount) {
        return destinationAccount != null && !sourceAccount.getAccountNumber().equals(destinationAccount.getAccountNumber());
    }

    // Check if the source account has sufficient funds for withdrawal or transfer
    public static boolean hasSufficientFunds(Account sourceAccount, double amount) {
        return sourceAccount.getBalance() >= amount;
    }

    public static boolean validateStatement(String statementID, String customerID, List<String> transactions, String statementDate) {
        // Example validation logic
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
        // Additional validation rules can be added here
        return true;
    }

}
