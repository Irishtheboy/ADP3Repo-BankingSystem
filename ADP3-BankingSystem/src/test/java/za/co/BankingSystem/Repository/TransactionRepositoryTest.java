package za.co.BankingSystem.Repository;

import org.junit.jupiter.api.*;

import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Transactions;
import za.co.BankingSystem.Factory.TransactionsFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Author: Franco Lukhele
 */

class TransactionRepositoryTest {
    private TransactionRepository repository;
    private Transactions transaction;

    @BeforeEach
    void setUp() {
        repository = TransactionRepository.getRepository();

        Account account = new Account.Builder()
                //.setAccountID("ACC1001")
                .setBalance(5000.00)
                .build();

        transaction = TransactionsFactory.createTransaction("Deposit", 1000.00, account, null);
        repository.create(transaction);
    }

    @Test
    void testCreateTransaction() {
        Transactions newTransaction = TransactionsFactory.createTransaction("Withdrawal", 500.00, transaction.getSourceAccount(), null);
        Transactions savedTransaction = repository.create(newTransaction);

        assertNotNull(savedTransaction);
        assertEquals(newTransaction.getTransactionID(), savedTransaction.getTransactionID());
    }

    @Test
    void testReadTransaction() {
        Transactions foundTransaction = repository.read(transaction.getTransactionID());

        assertNotNull(foundTransaction);
        assertEquals(transaction.getTransactionID(), foundTransaction.getTransactionID());
    }

    @Test
    void testUpdateTransaction() {
        Transactions updatedTransaction = new Transactions.Builder()
                .setTransactionID(transaction.getTransactionID())
                .setTransactionType("Transfer")
                .setAmount(1500.00)
                .setTransactionDate(transaction.getTransactionDate())
                .setSourceAccount(transaction.getSourceAccount())
                .build();

        Transactions result = repository.update(updatedTransaction);

        assertNotNull(result);
        assertEquals("Transfer", result.getTransactionType());
        assertEquals(1500.00, result.getAmount());
    }

    @Test
    void testDeleteTransaction() {
        assertTrue(repository.delete(transaction.getTransactionID()));

        Transactions deletedTransaction = repository.read(transaction.getTransactionID());
        assertNull(deletedTransaction);
    }

    @Test
    void testGetAllTransactions() {
        List<Transactions> transactionsList = repository.getAll();

        assertNotNull(transactionsList);
        assertFalse(transactionsList.isEmpty());
    }
}
