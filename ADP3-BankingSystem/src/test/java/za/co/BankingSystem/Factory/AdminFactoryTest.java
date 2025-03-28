
package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Admin;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
/**
 * AdminTest.java
 * Admin Test class
 *
 * Author: Franco Lukhele(222462914)
 * 28 March 2025
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminFactoryTest {

    private static Admin admin1 = AdminFactory.createAdmin("Naqeebah Khan", "naqeebah.khan@gmail.com", "Manager", "1234567890");
    private static Admin admin2 = AdminFactory.createAdmin("Franco Lukhele", "franco.lukhele@gmail.com", "Admin", "1234567891");
    private static Admin admin3 = AdminFactory.createAdmin("Teyannah Raubenheimer", "teyannah.raubenheimer@gmail.com", "Manager", "1234567892");
    private static Admin admin4 = AdminFactory.createAdmin("Seymour DaBoy", "seymour.daboy@gmail.com", "Manager", "1234567893");
    private static Admin admin5 = AdminFactory.createAdmin("Rorisang Simphiwe", "rorisang.simphiwe@gmail.com", "Admin", "1234567894");

    @Test
    @Order(1)
    public void testCreateAdmin1() {
        assertNotNull(admin1);
        System.out.println(admin1.toString());
    }

    @Test
    @Order(2)
    public void testCreateAdmin2() {
        assertNotNull(admin2);
        System.out.println(admin2.toString());
    }

    @Test
    @Order(3)
    public void testCreateAdmin3() {
        assertNotNull(admin3);
        System.out.println(admin3.toString());
    }

    @Test
    @Order(4)
    public void testCreateAdmin4() {
        assertNotNull(admin4);
        System.out.println(admin4.toString());
    }

    @Test
    @Order(5)
    public void testCreateAdmin5() {
        assertNotNull(admin5);
        System.out.println(admin5.toString());
    }

    @Test
    @Order(6)
    public void testCreateAdminWithInvalidName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AdminFactory.createAdmin("", "naqeebah.khan@gmail.com", "Manager", "1234567890");
        });
        assertEquals("Name cannot be empty", exception.getMessage());
    }

    @Test
    @Order(7)
    public void testCreateAdminWithInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AdminFactory.createAdmin("Naqeebah Khan", "invalid-email", "Manager", "1234567890");
        });
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    @Order(8)
    public void testCreateAdminWithEmptyRole() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AdminFactory.createAdmin("Naqeebah Khan", "naqeebah.khan@gmail.com", "", "1234567890");
        });
        assertEquals("Role cannot be empty", exception.getMessage());
    }

    @Test
    @Order(9)
    public void testCreateAdminWithInvalidPhoneNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AdminFactory.createAdmin("Naqeebah Khan", "naqeebah.khan@gmail.com", "Manager", "invalid-phone");
        });
        assertEquals("Invalid phone number format", exception.getMessage());
    }
}
