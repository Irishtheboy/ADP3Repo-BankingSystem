package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Customer;

public class CustomerFactory {
    public static Customer createCustomer(String customerID, String customerName, String customerAddress, STring customerEmail, String phoneNumber, List<Account> accounts){
        return new Customer.Builder()
                .setCustomerID(customerID)
                .setcustomerName(customerName)
                .setcustomerAddress(customerAddress)
                .setcustomerEmail(customerEmail)
                .setPhoneNumber(phoneNumber)
                .setAccounts(accounts)
                .build();
    }
}