package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.SavingsAccount;

import java.util.List;

public interface ISavingsAccount extends IRepository {
    SavingsAccount create(SavingsAccount savingsAccount);

    String read(String accountID);
    SavingsAccount update(SavingsAccount savingsAccount);
    boolean delete(String accountID);
    List<SavingsAccount> getAll();

}
