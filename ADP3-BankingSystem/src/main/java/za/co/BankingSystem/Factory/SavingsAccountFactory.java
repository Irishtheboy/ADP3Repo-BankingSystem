/*
 * SavingsAccountFactory.java
 * SavingsAccountFactory Class
 * Author: Rorisang Makgana (230602363)
 * Date: 28th March 2025
 */
package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.SavingsAccount;
import za.co.BankingSystem.Util.Helper;

public class SavingsAccountFactory {
    public static SavingsAccount createSavingsAccount(
    double interestRate,
    double minimumBalance,
    int withdrawLimit
    ) {

        if(!Helper.isValidInterestRate(interestRate)){
            return null;
        }
        if(!Helper.isValidMinimumBalance(minimumBalance)){
            return null;
        }
        return new SavingsAccount.Builder()
                .interestRate(interestRate)
                .withdrawLimit(withdrawLimit)
                .minimumBalance(minimumBalance)
                .build();
    }
}
