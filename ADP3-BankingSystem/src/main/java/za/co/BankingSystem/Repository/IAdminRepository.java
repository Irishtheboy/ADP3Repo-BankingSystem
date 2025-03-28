package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Admin;
import za.co.BankingSystem.Domain.Transactions;

import java.util.List;
/**
 * IAdminRepo.java
 * Admin Repo class
 *
 * Author: Franco Lukhele(222462914)
 * 28 March 2025
 */
public interface IAdminRepository extends IRepository<Admin, String> {
    List<Admin> getAll();

}
