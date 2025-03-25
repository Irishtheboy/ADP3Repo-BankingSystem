package za.co.BankingSystem.Util;

import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {


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

    // Check if an amount is valid (greater than zero)
    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }
}
