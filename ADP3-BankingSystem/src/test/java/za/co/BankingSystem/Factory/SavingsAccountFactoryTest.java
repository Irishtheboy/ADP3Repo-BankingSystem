package za.co.BankingSystem.Factory;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(OrderAnnotation.class)
class SavingsAccountFactoryTest {
    SavingsAccountFactory savingsFactory1 = new SavingsAccountFactory();
    SavingsAccountFactory savingsFactory2 = new SavingsAccountFactory();
    SavingsAccountFactory savingsFactory3 = new SavingsAccountFactory();

    @Test
    @Order(1)
    public void testCreateSavingsAccount() {
        assertNotNull(savingsFactory1);
    }
    @Test
    @Order(2)
    public void testCreateSavingsAccountWithAllParams() {
        assertNotNull(savingsFactory2);
    }
    @Test
    @Order(3)
    public void testFailSavingsAccount() {
        //fail(savingsFactory3);
    }

}