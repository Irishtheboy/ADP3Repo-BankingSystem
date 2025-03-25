package za.co.BankingSystem.Repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Transactions;
import za.co.BankingSystem.Factory.TransactionsFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionRepositoryTest {
    private TransactionRepository repository;
    private Transactions transaction;

    @BeforeEach
    void setUp() {
        repository = TransactionRepository.getRepository();


        Account sourceAccount = new Account.Builder()
                //.setAccountID("12345")
                .setBalance(1000)
                .build();

        Account destinationAccount = new Account.Builder()
                //.setAccountID("67890")
                .setBalance(500)
                .build();


        transaction = TransactionsFactory.createTransaction("Deposit", 200.00, sourceAccount, null);


        repository.create(transaction);
    }

    @Test
    void create() {
        Transactions newTransaction = TransactionsFactory.createTransaction("Withdrawal", 100.00, transaction.getSourceAccount(), null);
        Transactions savedTransaction = repository.create(newTransaction);

        assertNotNull(savedTransaction);
        assertEquals(newTransaction.getTransactionID(), savedTransaction.getTransactionID());
    }

    @Test
    void read() {
        Transactions foundTransaction = repository.read(transaction.getTransactionID());
        assertNotNull(foundTransaction);
        assertEquals(transaction.getTransactionID(), foundTransaction.getTransactionID());
    }

    @Test
    void update() {
        Transactions updatedTransaction = new Transactions.Builder()
                .setTransactionID(transaction.getTransactionID()) // Keep the same ID
                .setTransactionType("Transfer")
                .setAmount(300.00)
                .setTransactionDate(transaction.getTransactionDate())
                .setSourceAccount(transaction.getSourceAccount())
                .setDestinationAccount(transaction.getDestinationAccount())
                .build();

        Transactions result = repository.update(updatedTransaction);

        assertNotNull(result);
        assertEquals("Transfer", result.getTransactionType());
        assertEquals(300.00, result.getAmount());
    }

    @Test
    void delete() {
        boolean success = repository.delete(transaction.getTransactionID());
        assertTrue(success);

        Transactions deletedTransaction = repository.read(transaction.getTransactionID());
        assertNull(deletedTransaction);
    }

    @Test
    void getAll() {
        List<Transactions> transactionsList = repository.getAll();
        assertNotNull(transactionsList);
        assertFalse(transactionsList.isEmpty());
    }
}
