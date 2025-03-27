package za.co.BankingSystem.Factory;

import org.junit.jupiter.api.*;
import za.co.BankingSystem.Domain.CheckingAccount;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CheckingAccountFactoryTest {

    private static CheckingAccount c1 = CheckingAccountFactory.CreateCheckingAccount(5000.00, 100.00);
    private static CheckingAccount c2 = CheckingAccountFactory.CreateCheckingAccount(3000.00, 50.00);
    private static CheckingAccount c3 = CheckingAccountFactory.CreateCheckingAccount(7000.00, 120.00);

    @Test
    @Order(1)
    public void testCreateCheckingAccount1() {
        assertNotNull(c1);
        assertNotNull(c1.getCheckingAccountID());
        assertNotNull(c1.getDebitCardNumber());
        assertTrue(c1.getOverdraftLimit() > 0);
        assertTrue(c1.getMonthlyFee() > 0);
        System.out.println(c1.toString());
    }

    @Test
    @Order(2)
    public void testCreateCheckingAccount2() {
        assertNotNull(c2);
        assertNotNull(c2.getCheckingAccountID());
        assertNotNull(c2.getDebitCardNumber());
        assertTrue(c2.getOverdraftLimit() > 0);
        assertTrue(c2.getMonthlyFee() > 0);
        System.out.println(c2.toString());
    }

    @Test
    @Order(3)
    public void testCreateCheckingAccount3() {
        assertNotNull(c3);
        assertNotNull(c3.getCheckingAccountID());
        assertNotNull(c3.getDebitCardNumber());
        assertTrue(c3.getOverdraftLimit() > 0);
        assertTrue(c3.getMonthlyFee() > 0);
        System.out.println(c3.toString());
    }

    @Test
    @Order(4)
    public void testInvalidOverdraftLimit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CheckingAccountFactory.CreateCheckingAccount(-200.00, 50.00);
        });

        assertEquals("Overdraft limit must be greater than zero", exception.getMessage());
    }

    @Test
    @Order(5)
    public void testInvalidMonthlyFee() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CheckingAccountFactory.CreateCheckingAccount(5000.00, -10.00);
        });

        assertEquals("Monthly fee must be greater than zero", exception.getMessage());
    }
}

