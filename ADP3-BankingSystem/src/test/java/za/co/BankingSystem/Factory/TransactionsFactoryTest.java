package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Transactions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsFactoryTest {

    private Account sourceAccount;
    private Account destinationAccount;

    @BeforeEach
    void setUp() {
        sourceAccount = new Account.Builder()
                .setAccountNumber("A100")
                .setAccountType("Savings")
                .setBalance(5000)
                .setDateOpened(new Date())
                .build();

        destinationAccount = new Account.Builder()
                .setAccountNumber("B200")
                .setAccountType("Checking")
                .setBalance(3000)
                .setDateOpened(new Date())
                .build();
    }

    @Test
    void testCreateDepositTransaction() {
        Transactions transaction = TransactionsFactory.createTransaction("Deposit", 1000, sourceAccount, null);
        assertNotNull(transaction);
        assertEquals("Deposit", transaction.getTransactionType());
        assertEquals(1000, transaction.getAmount());
        assertEquals(sourceAccount.getAccountNumber(), transaction.getSourceAccount().getAccountNumber());
        assertNull(transaction.getDestinationAccount());

        // Verify balance updates
        assertEquals(6000, transaction.getSourceAccount().getBalance());
    }

    @Test
    void testCreateWithdrawalTransaction() {
        Transactions transaction = TransactionsFactory.createTransaction("Withdrawal", 500, sourceAccount, null);
        assertNotNull(transaction);
        assertEquals("Withdrawal", transaction.getTransactionType());
        assertEquals(500, transaction.getAmount());
        assertEquals(sourceAccount.getAccountNumber(), transaction.getSourceAccount().getAccountNumber());
        assertNull(transaction.getDestinationAccount());

        // Verify balance updates
        assertEquals(4500, transaction.getSourceAccount().getBalance());
    }

    @Test
    void testCreateTransferTransaction() {
        Transactions transaction = TransactionsFactory.createTransaction("Transfer", 1500, sourceAccount, destinationAccount);

        assertNotNull(transaction);
        assertEquals("Transfer", transaction.getTransactionType());
        assertEquals(1500, transaction.getAmount());
        assertEquals(sourceAccount.getAccountNumber(), transaction.getSourceAccount().getAccountNumber());
        assertEquals(destinationAccount.getAccountNumber(), transaction.getDestinationAccount().getAccountNumber());

        // Verify balance updates
        assertEquals(3500, transaction.getSourceAccount().getBalance()); // Source should decrease
        assertEquals(4500, transaction.getDestinationAccount().getBalance()); // Destination should increase
    }

    @Test
    void testCreateTransactionWithInvalidType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                TransactionsFactory.createTransaction("InvalidType", 1500, sourceAccount, destinationAccount)
        );
        assertEquals("Invalid transaction type", exception.getMessage());
    }

    @Test
    void testCreateTransactionWithNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                TransactionsFactory.createTransaction("Deposit", -1000, sourceAccount, null)
        );
        assertEquals("Transaction amount must be greater than zero", exception.getMessage());
    }

    @Test
    void testCreateTransactionWithNullSourceAccount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                TransactionsFactory.createTransaction("Deposit", 1000, null, null)
        );
        assertEquals("Source account cannot be null", exception.getMessage());
    }

    @Test
    void testCreateTransactionWithEmptyTransactionType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                TransactionsFactory.createTransaction("", 1000, sourceAccount, null)
        );
        assertEquals("Transaction type cannot be empty", exception.getMessage());
    }
}
