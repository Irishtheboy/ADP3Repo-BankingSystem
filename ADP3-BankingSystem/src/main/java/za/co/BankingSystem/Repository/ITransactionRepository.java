package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Transactions;

import java.util.List;

public interface ITransactionRepository extends IRepository<Transactions, String> {
    List<Transactions> getAll();
}
