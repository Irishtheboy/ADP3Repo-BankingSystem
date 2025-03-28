/*StatementFactoryTest.java
Statement Factory Test class
Author: Naqeebah Khan(219099073)
date: 28th March 2025*/

package za.co.BankingSystem.Factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.co.BankingSystem.Domain.Statement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;


import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StatementFactoryTest {

    private static List<String> emptyTransactionList = new ArrayList<>();
    private static List<String> validTransactionList = new ArrayList<>();

    static {
        validTransactionList.add("Deposit of R1000 was added");
        validTransactionList.add("R100 was withdrawn.");
    }

    private static Statement s1 = StatementFactory.createStatement("S001", "C001", validTransactionList, "2025-03-23");
    private static Statement s2 = StatementFactory.createStatement("S002", "C002", emptyTransactionList, "2025-03-24");
    private static Statement s3 = StatementFactory.createStatement("S003", "C003", validTransactionList, "2025-03-25");
    private static Statement s4 = StatementFactory.createStatement("S004", "C004", emptyTransactionList, "2025-03-26");
    private static Statement s5 = StatementFactory.createStatement("S005", "C005", validTransactionList, "2025-03-27");

    @Test
    @Order(1)
    public void testCreateStatement1() {
        assertNotNull(s1);
        System.out.println(s1);
    }

    @Test
    @Order(2)
    public void testCreateStatement2() {
        assertNotNull(s2);
        System.out.println(s2);
        assertEquals(0, s2.getTransactions().size(), "Transaction list should be empty.");
    }

    @Test
    @Order(3)
    public void testCreateStatement3() {
        assertNotNull(s3);
        System.out.println(s3);
    }

    @Test
    @Order(4)
    public void testCreateStatement4() {
        assertNotNull(s4);
        System.out.println(s4);
    }

    @Test
    @Order(5)
    public void testCreateStatement5() {
        assertNotNull(s5);
        System.out.println(s5);
    }
}
