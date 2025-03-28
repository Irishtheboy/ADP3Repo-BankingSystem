package za.co.BankingSystem.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.co.BankingSystem.Domain.CheckingAccount;
import za.co.BankingSystem.Factory.CheckingAccountFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class CheckingAccountRepositoryTest {
    private static ICheckingAccountRepository repository = CheckingAccountRepository.getRepository();

    private CheckingAccount checkingAccount = CheckingAccountFactory.createCheckingAccount();

    @Test
    void create() {
        CheckingAccount created = repository.create(checkingAccount);
        assertNotNull(created);
        System.out.println(created.toString());
    }

    @Test
    void read() {
        CheckingAccount read = repository.read(checkingAccount.getCheckingAccountID());
        assertNotNull(read);
        System.out.println(read.toString());

    }

    @Test
    void update() {
        CheckingAccount newCheckingAccount = new CheckingAccount.Builder().copy(checkingAccount).setOverdraftLimit(5000)
                .build();
        CheckingAccount updated = repository.update(newCheckingAccount);
        assertNotNull(updated);
        System.out.println(updated.toString());
    }

    @Test
    void delete() {
        assertTrue(repository.delete(checkingAccount.getCheckingAccountID()));
        System.out.println("Success: checking account deleted");
    }

    @Test
    void findAll() {
        System.out.println(repository.findAll());
    }
}
