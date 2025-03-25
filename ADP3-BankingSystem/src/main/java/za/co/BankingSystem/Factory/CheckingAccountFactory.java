package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.CheckingAccount;
import za.co.BankingSystem.Util.Helper;

public class CheckingAccountFactory {
    public static CheckingAccount CreateCheckingAccount(double overdraftLimit, double monthlyFee) {
     if (!Helper.isValidAmount(overdraftLimit)) {
         throw new IllegalArgumentException("Overdraft limit must be greater than zero");
     }

     if (!Helper.isValidAmount(monthlyFee)) {
         throw new IllegalArgumentException("Monthly fee must be greater than zero");
     }

     String debitCardNumber = Helper.generateID().substring(0, 12).replace("-", "");

     return new CheckingAccount.Builder()
             .setOverdraftLimit(overdraftLimit)
             .setMonthlyFee(monthlyFee)
             .setDebitCardNumber(debitCardNumber)
             .build();
    }
}
