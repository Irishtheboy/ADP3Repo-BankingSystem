/*
 * AccountFactory.java
 * AccountFactory Class
 * Author: Rorisang Makgana (230602363)
 * Date: 28th March 2025
 */

package za.co.BankingSystem.Factory;
import za.co.BankingSystem.Domain.*;
import za.co.BankingSystem.Util.Helper;

import java.util.Date;

public class AccountFactory {
    public static Account createAccount(
        String accountNumber,
        String accountType,
        double balance,
        Date dateOpened,
        Customer customer
    ){
        if(!Helper.isValidAccountNumber(accountNumber)){
            return null;
        }
        if(!Helper.isValidAccountType(accountType)){
            return null;
        }
        return new Account.Builder()
        .accountNumber(accountNumber)
        .accountType(accountType)
        .balance(balance)
        .dateOpened(dateOpened)
        .customer(customer)
        .build();

    }
}
