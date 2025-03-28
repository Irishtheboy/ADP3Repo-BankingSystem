/*CustomerRepositoryTest.java
Customer Repository Test class
Author: Naqeebah Khan(219099073)
date: 28th March 2025*/
package za.co.BankingSystem.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Customer;
import za.co.BankingSystem.Factory.CustomerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerRepositoryTest {

    private static CustomerRepository repository = CustomerRepository.getRepository();
    private static List<Account> emptyAccountList = new ArrayList<>();
    private Customer customer = CustomerFactory.createCustomer("Naqeebah", "Khan", "88 Miami Street", "naqeebah@gmail.com", "0724346731", emptyAccountList);

    @Test
    void create() {
        Customer created = repository.create(customer);
        assertNotNull(created);
        System.out.println(created.toString());
    }

    @Test
    void read() {
        repository.create(customer);
        Customer read = repository.read(customer.getCustomerID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        repository.create(customer); //create new customer
        Customer updatedCustomer = new Customer.Builder()
                .copy(customer)
                .setCustomerName("Naqeebah Updated")
                .build();

        Customer updated = repository.update(updatedCustomer);
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
        assertFalse(repository.delete(customer.getCustomerID()));
        System.out.println("Success: Customer deleted");
    }

    @Test
    void findAll() {
        System.out.println(repository.findAll());
    }
}

