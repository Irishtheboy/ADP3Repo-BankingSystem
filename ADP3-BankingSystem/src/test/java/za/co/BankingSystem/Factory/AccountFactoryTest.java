/*
 * AccountFactoryTest.java
 * AccountFactoryTest Class
 * Author: Rorisang Makgana (230602363)
 * Date: 28th March 2025
 */
package za.co.BankingSystem.Factory;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class AccountFactoryTest {
    AccountFactory accountFactory1 = new AccountFactory();
    AccountFactory accountFactory2 = new AccountFactory();
    AccountFactory accountFactory3 = new AccountFactory();

    @Test
    @Order(1)
    public void testCreateAccount() {
        assertNotNull(accountFactory1);
    }
    @Test
    @Order(2)
    public void testAccountWithAllParams() {
        assertNotNull(accountFactory2);
    }
    @Test
    @Order(3)
    public void testFailAccount() {
        //fail(accountFactory3);
    }
}