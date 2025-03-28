package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.SavingsAccount;

public class SavingsAccountFactory {
    public static SavingsAccount createSavingsAccount(
            double interestRate,
    double minimumBalance,
    int withdrawLimit
    ) {
        return new SavingsAccount.Builder()
                .interestRate(interestRate)
                .withdrawLimit(withdrawLimit)
                .minimumBalance(minimumBalance)
                .build();
    }

    //2. Creating
}
