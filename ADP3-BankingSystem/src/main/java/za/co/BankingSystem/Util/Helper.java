package za.co.BankingSystem.Util;

import za.co.BankingSystem.Domain.Account;

import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {

    // Generate unique ID
    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    // Validate email format
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }

    // Validate phone number (basic check for digits and length)
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("\\d{10,15}");
    }

    // Validate non-empty strings
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    // Validate transaction amount (greater than zero)
    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    // Validate transaction type (Deposit, Withdrawal, Transfer)
    public static boolean isValidTransactionType(String type) {
        return type != null && (type.equalsIgnoreCase("Deposit") ||
                type.equalsIgnoreCase("Withdrawal") ||
                type.equalsIgnoreCase("Transfer"));
    }

    // Check if the source account has enough funds for a withdrawal/transfer
    public static boolean hasSufficientFunds(Account account, double amount) {
        return account != null && account.getBalance() >= amount;
    }

    // Validate transfer transaction (destination account must be different)
    public static boolean isValidTransfer(Account source, Account destination) {
        return destination != null && !source.getAccountNumber().equals(destination.getAccountNumber());
    }
}
