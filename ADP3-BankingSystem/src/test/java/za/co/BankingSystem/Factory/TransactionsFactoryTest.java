package za.co.BankingSystem.Factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.co.BankingSystem.Domain.Account;
import za.co.BankingSystem.Domain.Transactions;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TransactionsFactoryTest {

    // Sample accounts
    private static final Account sourceAccount = new Account.Builder()
            .setAccountNumber("A100")
            .setAccountType("Savings")
            .setBalance(5000)
            .setDateOpened(new Date())
            .build();

    private static final Account destinationAccount = new Account.Builder()
            .setAccountNumber("B200")
            .setAccountType("Checking")
            .setBalance(3000)
            .setDateOpened(new Date())
            .build();

    // Transactions
    private static final Transactions t1 = TransactionsFactory.createTransaction(
            "Deposit", 1000, sourceAccount, null);

    private static final Transactions t2 = TransactionsFactory.createTransaction(
            "Withdrawal", 500, sourceAccount, null);

    private static final Transactions t3 = TransactionsFactory.createTransaction(
            "Transfer", 1500, sourceAccount, destinationAccount);

    private static final Transactions t4 = TransactionsFactory.createTransaction(
            "Payment", 200, sourceAccount, destinationAccount);

    private static final Transactions t5 = TransactionsFactory.createTransaction(
            "Refund", 300, destinationAccount, sourceAccount);


    @Test
    @Order(1)
    public void testCreateTransaction1() {
        assertNotNull(t1);
        System.out.println(t1.toString());
    }

    @Test
    @Order(2)
    public void testCreateTransaction2() {
        assertNotNull(t2);
        System.out.println(t2.toString());
    }

    @Test
    @Order(3)
    public void testCreateTransaction3() {
        assertNotNull(t3);
        System.out.println(t3.toString());
    }

    @Test
    @Order(4)
    public void testCreateTransaction4() {
        assertNotNull(t4);
        System.out.println(t4.toString());
    }

    @Test
    @Order(5)
    public void testCreateTransaction5() {
        assertNotNull(t5);
        System.out.println(t5.toString());
    }
}
