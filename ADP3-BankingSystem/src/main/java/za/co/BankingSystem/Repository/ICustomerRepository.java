/*ICustomerRepository.java
Customer Repository Interface
Author: Naqeebah Khan(219099073)
date: 26th March 2025*/
package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Customer;
import java.util.List;

public interface ICustomerRepository extends IRepository<Customer, String> {
    List<Customer> findAll();
}

