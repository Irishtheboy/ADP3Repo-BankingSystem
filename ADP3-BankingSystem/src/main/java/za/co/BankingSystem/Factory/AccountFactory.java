package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Customer;
import za.co.BankingSystem.Util.Helper;

import java.util.Date;

public class AccountFactory {
    public static Account createAccount(
            String accountNumber,
            String accountType,
            double balance,
            Date dateOpened,
            Customer customer
    ) {

        if (Helper.isNullOrEmpty(accountNumber) || Helper.isNullOrEmpty(accountType)) {
            throw new IllegalArgumentException("Account number and account type cannot be empty");
        }

        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }

        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }

        if (dateOpened == null || dateOpened.after(new Date())) {
            throw new IllegalArgumentException("Invalid account opening date");
        }


        return new Account.Builder()
                .setAccountNumber(accountNumber)
                .setAccountType(accountType)
                .setBalance(balance)
                .setDateOpened(dateOpened)
                .setCustomer(customer)
                .build();
    }
}
