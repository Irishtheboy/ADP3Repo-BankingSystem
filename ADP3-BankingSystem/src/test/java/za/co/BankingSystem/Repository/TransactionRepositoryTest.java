package za.co.BankingSystem.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Transactions;
import za.co.BankingSystem.Factory.TransactionsFactory;


/**
 * TransactionTest.java
 * Transaction Test class
 *
 * Author: Franco Lukhele(222462914)
 * 28 March 2025
 */
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class TransactionRepositoryTest {
    private static ITransactionRepository repository = TransactionRepository.getRepository();
    private Transactions transaction = TransactionsFactory.createTransaction("Deposit", 200.00, new Account.Builder().setBalance(1000).build(), null);

    @Test
    void create() {
        Transactions created = repository.create(transaction);
        assertNotNull(created);
        System.out.println(created.toString());
    }

    @Test
    void read() {
        repository.create(transaction);
        Transactions read = repository.read(transaction.getTransactionID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        repository.create(transaction);

        Transactions updatedTransaction = new Transactions.Builder()
                .setTransactionID(transaction.getTransactionID())
                .setTransactionType("Transfer")
                .setAmount(300.00)
                .setTransactionDate(transaction.getTransactionDate())
                .setSourceAccount(transaction.getSourceAccount())
                .setDestinationAccount(transaction.getDestinationAccount())
                .build();

        Transactions updated = repository.update(updatedTransaction);
        assertNotNull(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    void delete() {
        assertFalse(repository.delete(transaction.getTransactionID()));
        System.out.println("Success: transaction deleted");
    }

    @Test
    void findAll() {
        System.out.println(repository.getAll());
    }
}
