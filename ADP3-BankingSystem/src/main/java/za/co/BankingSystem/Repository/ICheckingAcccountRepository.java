package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.CheckingAccount;

import java.util.List;

public interface ICheckingAcccountRepository extends IRepository<CheckingAccount, String> {
    List<CheckingAccount> findAll();
}
