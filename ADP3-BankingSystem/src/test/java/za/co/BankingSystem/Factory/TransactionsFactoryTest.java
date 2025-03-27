package za.co.BankingSystem.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Transactions;

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
        assertEquals(sourceAccount, transaction.getSourceAccount());
        assertNull(transaction.getDestinationAccount());
    }

    @Test
    void testCreateWithdrawalTransaction() {
        Transactions transaction = TransactionsFactory.createTransaction("Withdrawal", 500, sourceAccount, null);
        assertNotNull(transaction);
        assertEquals("Withdrawal", transaction.getTransactionType());
        assertEquals(500, transaction.getAmount());
        assertEquals(sourceAccount, transaction.getSourceAccount());
        assertNull(transaction.getDestinationAccount());
    }

    @Test
    void testCreateTransferTransaction() {
        double transferAmount = 1500;

        // Save initial balances for comparison
        double initialSourceBalance = sourceAccount.getBalance();
        double initialDestinationBalance = destinationAccount.getBalance();

        // Create the transfer transaction
        Transactions transaction = TransactionsFactory.createTransaction("Transfer", transferAmount, sourceAccount, destinationAccount);

        // Assert that the transaction is not null
        assertNotNull(transaction, "Transaction should not be null");

        // Assert the transaction type is "Transfer"
        assertEquals("Transfer", transaction.getTransactionType(), "Transaction type should be Transfer");

        // Assert the transaction amount is correct
        assertEquals(transferAmount, transaction.getAmount(), "Transaction amount should be " + transferAmount);

        // Assert the source account is correct
        assertEquals(sourceAccount, transaction.getSourceAccount(), "Source account should match the provided source account");

        // Assert the destination account is correct
        assertEquals(destinationAccount, transaction.getDestinationAccount(), "Destination account should match the provided destination account");

        // Assert the source account balance has decreased by the transfer amount
        assertEquals(initialSourceBalance - transferAmount, sourceAccount.getBalance(), "Source account balance should decrease by " + transferAmount);

        // Assert the destination account balance has increased by the transfer amount
        assertEquals(initialDestinationBalance + transferAmount, destinationAccount.getBalance(), "Destination account balance should increase by " + transferAmount);
    }


    @Test
    void testCreateTransferTransactionWithoutDestinationAccount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                TransactionsFactory.createTransaction("Transfer", 1500, sourceAccount, null)
        );
        assertEquals("Destination account is required for a transfer", exception.getMessage());
    }

    @Test
    void testCreateInvalidTransactionType() {
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
