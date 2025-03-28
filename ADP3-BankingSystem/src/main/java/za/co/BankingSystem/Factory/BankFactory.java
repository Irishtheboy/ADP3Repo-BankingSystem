/*BankFactory.java
  BankFactory Class
  Author: Teyana Raubenheimer (230237622)
  Date: 12 March 2025
 */

package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Bank;
import za.co.BankingSystem.Domain.Customer;
import za.co.BankingSystem.Util.Helper;

import java.util.ArrayList;
import java.util.List;

public class BankFactory {
    public static Bank createBank(String bankName, String address, String contactNumber) {
        if (Helper.isNullOrEmpty(bankName) || Helper.isNullOrEmpty(address)) {
            throw new IllegalArgumentException("Bank name or address cannot be empty");
        }

        if (!Helper.isValidPhoneNumber(contactNumber)) {
            throw new IllegalArgumentException("Contact number is invalid");
        }

        String bankID = Helper.generateID();

        return new Bank.Builder()
                .setBankName(bankName)
                .setBankID(bankID)
                .setAddress(address)
                .setContactNumber(contactNumber)
                .setCustomers(new ArrayList<>())
                .setAccounts(new ArrayList<>())
                .build();
    }

    public static Bank createBankWithCustomersAndAccounts(String bankName, String address, String contactNumber, List<Customer> customers, List<Account> accounts) {
        if (Helper.isNullOrEmpty(bankName) || Helper.isNullOrEmpty(address)) {
            throw new IllegalArgumentException("Bank name or address cannot be empty");
        }

        if (!Helper.isValidPhoneNumber(contactNumber)) {
            throw new IllegalArgumentException("Contact number is invalid");
        }

        String bankID = Helper.generateID();

        return new Bank.Builder()
                .setBankName(bankName)
                .setBankID(bankID)
                .setAddress(address)
                .setContactNumber(contactNumber)
                .setCustomers(customers != null ? customers : new ArrayList<>())
                .setAccounts(accounts != null ? accounts : new ArrayList<>())
                .build();
    }


}
