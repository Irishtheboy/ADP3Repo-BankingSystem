package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Transactions;

import java.util.List;
/**
 *ITransactionRepo.java
 * Admin model class
 *
 * Author: Franco Lukhele(222462914)
 * 28 March 2025
 */
public interface ITransactionRepository extends IRepository<Transactions, String> {
    List<Transactions> getAll();
}
