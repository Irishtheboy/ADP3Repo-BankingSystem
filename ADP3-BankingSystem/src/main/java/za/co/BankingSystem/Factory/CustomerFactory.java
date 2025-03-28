package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Customer;
import za.co.BankingSystem.Util.Helper;

import java.util.ArrayList;
import java.util.List;

public class CustomerFactory {

    public static Customer createCustomer(String customerName, String customerSurname,
                                          String customerAddress, String customerEmail, String phoneNumber,
                                          List<Account> accounts) {
        // Validate required fields
        if (Helper.isNullOrEmpty(customerName) || Helper.isNullOrEmpty(customerSurname) || Helper.isNullOrEmpty(customerAddress)) {
            throw new IllegalArgumentException("Customer name, surname, or address cannot be empty");
        }

        // Validate email format
        if (!Helper.isValidEmail(customerEmail)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        // Validate phone number
        if (!Helper.isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number");
        }

        // Generate unique customer ID
        String customerID = Helper.generateID();

        // Return a Customer object using the Builder pattern
        return new Customer.Builder()
                .setCustomerID(customerID)
                .setCustomerName(customerName)
                .setCustomerSurname(customerSurname)
                .setCustomerAddress(customerAddress)
                .setCustomerEmail(customerEmail)
                .setPhoneNumber(phoneNumber)
                .setAccounts(accounts != null ? accounts : new ArrayList<>()) // Avoid null lists
                .build();
    }
}
