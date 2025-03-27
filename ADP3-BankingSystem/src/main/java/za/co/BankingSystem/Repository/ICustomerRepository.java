//Naqeebah Khan 219099073
package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Customer;
import java.util.List;

public interface ICustomerRepository extends IRepository<Customer, String> {
    List<Customer> findAll();
}

