/*
 * IAccountRepository.java
 * IAccountRepository Class
 * Author: Rorisang Makgana (230602363)
 * Date: 28th March 2025
 */
package za.co.BankingSystem.Repository;
import za.co.BankingSystem.Domain.Account;

import java.util.List;

public interface IAccountRepository extends IRepository{
    Account create(Account account);

    String read(String accountId);

    Account update(Account account);

    boolean delete(String accountID);

    List<Account> getAll();
}