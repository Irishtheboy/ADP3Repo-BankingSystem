package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Bank;

import java.util.List;

public interface IBankRepository extends IRepository<Bank, String>{
    List<Bank> findAll();
}
