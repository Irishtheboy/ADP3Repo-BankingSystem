package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Bank;
import za.co.BankingSystem.Domain.CheckingAccount;

import java.util.List;

public interface ICheckingAcccount extends IRepository<CheckingAccount, String> {
    List<CheckingAccount> findAll();
}
