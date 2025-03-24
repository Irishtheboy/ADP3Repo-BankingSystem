package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Customer;

public class CustomerFactory {
    public static Customer createCustomer(String customerID, String customerName, String customerAddress, String customerEmail, String phoneNumber){
        return new Customer.Builder()
                .setCustomerID(customerID)
                .setCustomerName(customerName)
                .setCustomerAddress(customerAddress)
                .setCustomerEmail(customerEmail)
                .setPhoneNumber(phoneNumber)
                .build();
    }
}