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

    private static Customer c1 = CustomerFactory.createCustomer(
            "Naqeebah",
            "Khan",
            "88 Miami Street",
            "naqeebah@gmail.com"
            "0724346731",
            emptyAccountList
    );

    private static Customer c2 = CustomerFactory.createCustomer(
            "Franco",
            "Lukhele",
            "42 Barcelona Close",
            "francolukhele@gmail.com",
            "0739643861",
            emptyAccountList
    );

    @Test
    @Order(1)
    public void testCreateCustomer() {
        Customer created = repository.create(c1);
        assertNotNull(created);
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    public void testCreateCustomer() {
        Customer created = repository.create(c2);
        assertNotNull(created);
        System.out.println("Created: " + created);
    }

    @Test
    @Order(3)
    public void testReadCustomer() {
        Customer found = repository.read(c1.getCustomerID());
        assertNotNull(found);
        assertEquals(c1.getCustomerID(), found.getCustomerID());
        System.out.println("Read" + found);
    }

    @Test
    @Order(4)
    public void testUpdateCustomer() {
        Customer updateCustomer = CustomerFactory.createCustomer(
                "Naqeebah Updated",
                "Khan",
                "67 Town Street",
                "naqeebah@gmail.com_updated",
                "0819723826",
                emptyAccountList
        );

        Customer updated = repository.update(updatedCustomer);
        assertNotNull(updated);
        assertEquals("Naqeebah updated", updated.getCustomerName());
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(5)
    public void testDeleteCustomer() {
        boolean deleted = repository.delete(c2.getCustomerID());
        assertTrue(deleted);
        System.out.println("Deleted customerID: " + c2.getCustomerID());

    }

    @Test
    @Order(6)
    public void testReadAllCustomers() {
        List<Customer> allCustomers = repository.findAll();
        assertNotNull(allCustomers.isEmpty());
        System.out.println("All customers: "+ allCustomers);
    }




}
