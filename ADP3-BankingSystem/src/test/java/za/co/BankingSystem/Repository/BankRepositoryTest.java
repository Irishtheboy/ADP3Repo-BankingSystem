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
        Bank read = repository.read(bank.getBankID());
        assertNotNull(read);
        System.out.println(read.toString());

    }

    @Test
    void update() {
        Bank newBank = new Bank.Builder().copy(bank).setBankName("Standard Bank")
                .build();
        Bank updated = repository.update(newBank);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    void delete() {
       assertTrue(repository.delete(bank.getBankID()));
       System.out.println("Success: bank deleted");
    }

    @Test
    void findAll() {
        System.out.println(repository.findAll());
    }
}