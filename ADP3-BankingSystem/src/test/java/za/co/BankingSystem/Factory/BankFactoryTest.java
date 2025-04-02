/*BankFactoryTest.java
  BankFactoryTest Class
  Author: Teyana Raubenheimer (230237622)
  Date: 21 March 2025
 */

package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Bank;
import za.co.BankingSystem.Domain.Customer;
import za.co.BankingSystem.Domain.Account;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class BankFactoryTest {

    private static List<Customer> emptyCustomerList = new ArrayList<>();
    private static List<Account> emptyAccountList = new ArrayList<>();

    private static Bank b1 = BankFactory.createBank(
            "Standard Bank",
            "30 Main Street, Johannesburg",
            "0111234567"
    );

    private static Bank b2 = BankFactory.createBank(
            "ABSA",
            "20 Sandton Drive, Sandton",
            "0117654321"
    );

    private static Bank b3 = BankFactory.createBankWithCustomersAndAccounts(
            "Nedbank",
            "15 Cape Town Road, Cape Town",
            "0215557890",
            emptyCustomerList,
            emptyAccountList
    );

    private static Bank b4 = BankFactory.createBankWithCustomersAndAccounts(
            "FNB",
            "50 Pretoria Avenue, Pretoria",
            "0129991234",
            emptyCustomerList,
            emptyAccountList
    );

    private static Bank b5 = BankFactory.createBankWithCustomersAndAccounts(
            "Capitec",
            "5 Durban Street, Durban",
            "0318765432",
            emptyCustomerList,
            emptyAccountList
    );

    @Test
    @Order(1)
    public void testCreateBank1() {
        assertNotNull(b1);
        assertNotNull(b1.getBankID());
        System.out.println(b1.toString());
    }

    @Test
    @Order(2)
    public void testCreateBank2() {
        assertNotNull(b2);
        assertNotNull(b2.getBankID());
        System.out.println(b2.toString());
    }

    @Test
    @Order(3)
    public void testCreateBankWithCustomersAndAccounts1() {
        assertNotNull(b3);
        assertNotNull(b3.getBankID());
        assertTrue(b3.getCustomers().isEmpty());
        assertTrue(b3.getAccounts().isEmpty());
        System.out.println(b3.toString());
    }

    @Test
    @Order(4)
    public void testCreateBankWithCustomersAndAccounts2() {
        assertNotNull(b4);
        assertNotNull(b4.getBankID());
        assertTrue(b4.getCustomers().isEmpty());
        assertTrue(b4.getAccounts().isEmpty());
        System.out.println(b4.toString());
    }

    @Test
    @Order(5)
    public void testCreateBankWithCustomersAndAccounts3() {
        assertNotNull(b5);
        assertNotNull(b5.getBankID());
        assertTrue(b5.getCustomers().isEmpty());
        assertTrue(b5.getAccounts().isEmpty());
        System.out.println(b5.toString());
    }
}
