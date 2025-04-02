/*ICheckingAcccountRepository.java
  ICheckingAcccountRepository Class
  Author: Teyana Raubenheimer (230237622)
  Date: 18 March 2025
 */


package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.CheckingAccount;

import java.util.List;

public interface ICheckingAcccountRepository extends IRepository<CheckingAccount, String> {
    List<CheckingAccount> findAll();
}
