package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Admin;
import za.co.BankingSystem.Domain.Transactions;

import java.util.List;

public interface IAdminRepository extends IRepository<Admin, String> {
    List<Admin> getAll();

}
