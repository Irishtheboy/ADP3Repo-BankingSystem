/*IBankRepository.java
  IBankRepository Class
  Author: Teyana Raubenheimer (230237622)
  Date: 15 March 2025
 */

package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Bank;

import java.util.List;

public interface IBankRepository extends IRepository<Bank, String>{
    List<Bank> findAll();
}
