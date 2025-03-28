// Naqeebah Khan 219099073
package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Transactions;
import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransactionsFactoryTest {

    private static Account sourceAccount = new Account.Builder()
            .setAccountNumber("A100")
            .setAccountType("Savings")
            .setBalance(5000)
            .setDateOpened(new Date())
            .build();

    private static Account destinationAccount = new Account.Builder()
            .setAccountNumber("B200")
            .setAccountType("Checking")
            .setBalance(3000)
            .setDateOpened(new Date())
            .build();

    private static Transactions transaction1 = TransactionsFactory.createTransaction("Deposit", 1000, sourceAccount, null);
    private static Transactions transaction2 = TransactionsFactory.createTransaction("Withdrawal", 500, sourceAccount, null);
    private static Transactions transaction3 = TransactionsFactory.createTransaction("Transfer", 1500, sourceAccount, destinationAccount);

    @Test
    @Order(1)
    public void testCreateDepositTransaction() {
        assertNotNull(transaction1);
        System.out.println(transaction1.toString());
        assertEquals("Deposit", transaction1.getTransactionType());
        assertEquals(1000, transaction1.getAmount());
        assertEquals(sourceAccount.getAccountNumber(), transaction1.getSourceAccount().getAccountNumber());
        assertNull(transaction1.getDestinationAccount());

        // Verify balance updates
        assertEquals(6000, transaction1.getSourceAccount().getBalance());
    }

    @Test
    @Order(2)
    public void testCreateWithdrawalTransaction() {
        assertNotNull(transaction2);
        System.out.println(transaction2.toString());
        assertEquals("Withdrawal", transaction2.getTransactionType());
        assertEquals(500, transaction2.getAmount());
        assertEquals(sourceAccount.getAccountNumber(), transaction2.getSourceAccount().getAccountNumber());
        assertNull(transaction2.getDestinationAccount());

        // Verify balance updates
        assertEquals(4500, transaction2.getSourceAccount().getBalance());
    }

    @Test
    @Order(3)
    public void testCreateTransferTransaction() {
        assertNotNull(transaction3);
        System.out.println(transaction3.toString());
        assertEquals("Transfer", transaction3.getTransactionType());
        assertEquals(1500, transaction3.getAmount());
        assertEquals(sourceAccount.getAccountNumber(), transaction3.getSourceAccount().getAccountNumber());
        assertEquals(destinationAccount.getAccountNumber(), transaction3.getDestinationAccount().getAccountNumber());

        // Verify balance updates
        assertEquals(3500, transaction3.getSourceAccount().getBalance()); // Source should decrease
        assertEquals(4500, transaction3.getDestinationAccount().getBalance()); // Destination should increase
    }

    @Test
    @Order(4)
    public void testCreateTransactionWithInvalidType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TransactionsFactory.createTransaction("InvalidType", 1500, sourceAccount, destinationAccount);
        });
        assertEquals("Invalid transaction type", exception.getMessage());
    }

    @Test
    @Order(5)
    public void testCreateTransactionWithNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TransactionsFactory.createTransaction("Deposit", -1000, sourceAccount, null);
        });
        assertEquals("Transaction amount must be greater than zero", exception.getMessage());
    }

    @Test
    @Order(6)
    public void testCreateTransactionWithNullSourceAccount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TransactionsFactory.createTransaction("Deposit", 1000, null, null);
        });
        assertEquals("Source account cannot be null", exception.getMessage());
    }

//    @Test
//    @Order(7)
//    public void testCreateTransactionWithEmptyTransactionType() {
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            TransactionsFactory.createTransaction("", 1000, sourceAccount, null);
//        });
//        assertEquals("Transaction type cannot be empty", exception.getMessage());
//    }
}
