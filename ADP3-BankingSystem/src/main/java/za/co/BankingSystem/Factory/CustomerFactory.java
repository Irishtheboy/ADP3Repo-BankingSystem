// Naqeebah Khan 219099073
package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Customer;
import java.util.List;

public class CustomerFactory {
    public static Customer createCustomer(String customerID, String customerName, String customerSurname,
                                          String customerAddress, String customerEmail, String phoneNumber,
                                          List<Account> accounts) {
        return new Customer.Builder()
                .setCustomerID(customerID)
                .setCustomerName(customerName)
                .setCustomerSurname(customerSurname)
                .setCustomerAddress(customerAddress)
                .setCustomerEmail(customerEmail)
                .setPhoneNumber(phoneNumber)
                .setAccounts(accounts)
                .build();
    }
}
