/*BankRepositoryTest.java
  BankRepositoryTest Class
  Author: Teyana Raubenheimer (230237622)
  Date: 26 March 2025
 */

package za.co.BankingSystem.Repository;



import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.co.BankingSystem.Domain.Bank;
import za.co.BankingSystem.Factory.BankFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class BankRepositoryTest {
    private static IBankRepository repository = BankRepository.getRepository();
    private Bank bank = BankFactory.createBank("Capitec", "5 Durban Street, Durban", "0318765432");

    @Test
    void create() {
        Bank created = repository.create(bank);
        assertNotNull(created);
        System.out.println(created.toString());
    }

    @Test
    void read() {
        repository.create(bank);

        Bank read = repository.read(bank.getBankID());
        assertNotNull(read);
        System.out.println("Read: " + read);

    }

    @Test
    void update() {
        repository.create(bank); // Create record first

        Bank updatedBank = new Bank.Builder()
                .copy(bank)
                .setBankName("Standard Bank")
                .build();

        Bank updated = repository.update(updatedBank);
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
       assertFalse(repository.delete(bank.getBankID()));
       System.out.println("Success: bank deleted");
    }

    @Test
    void findAll() {
        System.out.println(repository.findAll());
    }
}