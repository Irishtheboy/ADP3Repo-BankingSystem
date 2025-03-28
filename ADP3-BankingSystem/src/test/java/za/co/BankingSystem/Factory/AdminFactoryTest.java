package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Admin;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    @BeforeEach
    void setUp() {
        // This method is used to set up any prerequisites for the tests, if needed.
    }

    @Test
    void testCreateAdminValidInput() {
        // Test creating an Admin with valid inputs
        Admin admin = AdminFactory.createAdmin("Naqeebah Khan", "naqeebah.khan@gmail.com", "Manager", "1234567890");

        assertNotNull(admin);
        assertEquals("Naqeebah Khan", admin.getName());
        assertEquals("naqeebah.khan@gmail.com", admin.getEmail());
        assertEquals("Manager", admin.getRole());
        assertEquals("1234567890", admin.getContactNumber());
    }

    @Test
    void testCreateAdminWithEmptyName() {
        // Test creating an Admin with an empty name
        Admin admin = AdminFactory.createAdmin("", "naqeebah.khan@gmail.com", "Manager", "1234567890");
        assertNull(admin);  // Admin creation should fail and return null
    }

    @Test
    void testCreateAdminWithInvalidEmail() {
        // Test creating an Admin with an invalid email
        Admin admin = AdminFactory.createAdmin("Naqeebah Khan", "invalid-email", "Manager", "1234567890");
        assertNull(admin);  // Admin creation should fail and return null
    }

    @Test
    void testCreateAdminWithEmptyRole() {
        // Test creating an Admin with an empty role
        Admin admin = AdminFactory.createAdmin("Naqeebah Khan", "naqeebah.khan@gmail.com", "", "1234567890");
        assertNull(admin);  // Admin creation should fail and return null
    }

    @Test
    void testCreateAdminWithInvalidPhoneNumber() {
        // Test creating an Admin with an invalid phone number
        Admin admin = AdminFactory.createAdmin("Naqeebah Khan", "naqeebah.khan@gmail.com", "Manager", "invalid-phone");
        assertNull(admin);  // Admin creation should fail and return null
    }

    @Test
    void testCreateAdminWithRorisangSimphiwe() {
        // Test creating an Admin with the name "Rorisang Simphiwe"
        Admin admin = AdminFactory.createAdmin("Rorisang Simphiwe", "rorisang.simphiwe@gmail.com", "Admin", "1234567891");

        assertNotNull(admin);
        assertEquals("Rorisang Simphiwe", admin.getName());
        assertEquals("rorisang.simphiwe@gmail.com", admin.getEmail());
        assertEquals("Admin", admin.getRole());
        assertEquals("1234567891", admin.getContactNumber());
    }

    @Test
    void testCreateAdminWithTeyannahRaubenheimer() {
        // Test creating an Admin with the name "Teyannah Raubenheimer"
        Admin admin = AdminFactory.createAdmin("Teyannah Raubenheimer", "teyannah.raubenheimer@gmail.com", "Manager", "1234567892");

        assertNotNull(admin);
        assertEquals("Teyannah Raubenheimer", admin.getName());
        assertEquals("teyannah.raubenheimer@gmail.com", admin.getEmail());
        assertEquals("Manager", admin.getRole());
        assertEquals("1234567892", admin.getContactNumber());
    }

    @Test
    void testCreateAdminWithFrancoLukhele() {
        // Test creating an Admin with the name "Franco Lukhele"
        Admin admin = AdminFactory.createAdmin("Franco Lukhele", "franco.lukhele@gmail.com", "Admin", "1234567893");

        assertNotNull(admin);
        assertEquals("Franco Lukhele", admin.getName());
        assertEquals("franco.lukhele@gmail.com", admin.getEmail());
        assertEquals("Admin", admin.getRole());
        assertEquals("1234567893", admin.getContactNumber());
    }

    @Test
    void testCreateAdminWithSeymourDaBoy() {
        // Test creating an Admin with the name "Seymour DaBoy"
        Admin admin = AdminFactory.createAdmin("Seymour DaBoy", "seymour.daboy@gmail.com", "Manager", "1234567894");

        assertNotNull(admin);
        assertEquals("Seymour DaBoy", admin.getName());
        assertEquals("seymour.daboy@gmail.com", admin.getEmail());
        assertEquals("Manager", admin.getRole());
        assertEquals("1234567894", admin.getContactNumber());
    }
}
