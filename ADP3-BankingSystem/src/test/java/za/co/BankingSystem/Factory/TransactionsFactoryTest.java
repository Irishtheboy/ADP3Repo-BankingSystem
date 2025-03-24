package za.co.BankingSystem.Factory;

import org.junit.jupiter.api.Test;
import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Transactions;
import za.co.BankingSystem.Util.Helper;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsFactoryTest {

    @Test
    void createTransaction_Success() {
        // Arrange - Create sample accounts
        Account sourceAccount = new Account.Builder()
                .setAccountNumber("123456")
                .setAccountType("Savings")
                .setBalance(5000)
                .setDateOpened(new Date())
                .build();

        Account destinationAccount = new Account.Builder()
                .setAccountNumber("654321")
                .setAccountType("Checking")
                .setBalance(3000)
                .setDateOpened(new Date())
                .build();

        // Act - Create a transaction
        Transactions transaction = TransactionsFactory.createTransaction("Transfer", 1000, sourceAccount, destinationAccount);

        // Assert - Validate properties
        assertNotNull(transaction);
        assertNotNull(transaction.getTransactionID());
        assertEquals("Transfer", transaction.getTransactionType());
        assertEquals(1000, transaction.getAmount());
        assertEquals(sourceAccount, transaction.getSourceAccount());
        assertEquals(destinationAccount, transaction.getDestinationAccount());
    }

    @Test
    void createTransaction_InvalidAmount_ShouldThrowException() {
        // Arrange
        Account sourceAccount = new Account.Builder()
                .setAccountNumber("123456")
                .setAccountType("Savings")
                .setBalance(5000)
                .setDateOpened(new Date())
                .build();

        // Act & Assert - Expect an exception for invalid amount
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TransactionsFactory.createTransaction("Deposit", -500, sourceAccount, null);
        });

        assertEquals("Transaction amount must be greater than zero", exception.getMessage());
    }

    @Test
    void createTransaction_MissingSourceAccount_ShouldThrowException() {
        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TransactionsFactory.createTransaction("Withdrawal", 500, null, null);
        });

        assertEquals("Source account cannot be null", exception.getMessage());
    }

    @Test
    void createTransaction_TransferWithoutDestination_ShouldThrowException() {
        // Arrange
        Account sourceAccount = new Account.Builder()
                .setAccountNumber("123456")
                .setAccountType("Savings")
                .setBalance(5000)
                .setDateOpened(new Date())
                .build();

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TransactionsFactory.createTransaction("Transfer", 1000, sourceAccount, null);
        });

        assertEquals("Destination account is required for a transfer", exception.getMessage());
    }
}
