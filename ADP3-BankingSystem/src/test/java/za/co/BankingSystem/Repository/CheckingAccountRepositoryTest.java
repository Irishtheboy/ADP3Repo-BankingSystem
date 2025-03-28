package za.co.BankingSystem.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.co.BankingSystem.Domain.CheckingAccount;
import za.co.BankingSystem.Factory.CheckingAccountFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CheckingAccountRepositoryTest {

    private static ICheckingAccountRepository repository = CheckingAccountRepository.getRepository();
    private static CheckingAccount checkingAccount = CheckingAccountFactory.createCheckingAccount();

    @Test
    void create() {
        CheckingAccount created = repository.create(checkingAccount);
        assertNotNull(created);
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        // Ensure checking account is created before reading
        repository.create(checkingAccount);

        CheckingAccount read = repository.read(checkingAccount.getCheckingAccountID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        // Ensure checking account is created before updating
        repository.create(checkingAccount);

        CheckingAccount newCheckingAccount = new CheckingAccount.Builder()
                .copy(checkingAccount)
                .setOverdraftLimit(5000)
                .build();

        CheckingAccount updated = repository.update(newCheckingAccount);
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
        // Ensure checking account is created before deleting
        repository.create(checkingAccount);

        boolean success = repository.delete(checkingAccount.getCheckingAccountID());
        assertTrue(success);
        System.out.println("Success: Checking account deleted");
    }

    @Test
    void findAll() {
        System.out.println("All Checking Accounts: " + repository.findAll());
    }
}

