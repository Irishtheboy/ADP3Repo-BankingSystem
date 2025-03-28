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
        Admin admin = AdminFactory.createAdmin("Naqeebah Khan", "naqeebah.khan@gmail.com", "Manager", "1234567890");

        assertNotNull(admin, "Admin should be successfully created.");
        assertEquals("Naqeebah Khan", admin.getName());
        assertEquals("naqeebah.khan@gmail.com", admin.getEmail());
        assertEquals("Manager", admin.getRole());
        assertEquals("1234567890", admin.getContactNumber());
    }

    @Test
    void testCreateAdminWithEmptyName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                AdminFactory.createAdmin("", "naqeebah.khan@gmail.com", "Manager", "1234567890")
        );
        assertEquals("Name cannot be empty", exception.getMessage());
    }

    @Test
    void testCreateAdminWithInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                AdminFactory.createAdmin("Naqeebah Khan", "invalid-email", "Manager", "1234567890")
        );
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void testCreateAdminWithEmptyRole() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                AdminFactory.createAdmin("Naqeebah Khan", "naqeebah.khan@gmail.com", "", "1234567890")
        );
        assertEquals("Role cannot be empty", exception.getMessage());
    }

    @Test
    void testCreateAdminWithInvalidPhoneNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                AdminFactory.createAdmin("Naqeebah Khan", "naqeebah.khan@gmail.com", "Manager", "invalid-phone")
        );
        assertEquals("Invalid phone number format", exception.getMessage());
    }

    @Test
    void testCreateAdminWithValidNames() {
        String[][] admins = {
                {"Rorisang Simphiwe", "rorisang.simphiwe@gmail.com", "Admin", "1234567891"},
                {"Teyannah Raubenheimer", "teyannah.raubenheimer@gmail.com", "Manager", "1234567892"},
                {"Franco Lukhele", "franco.lukhele@gmail.com", "Admin", "1234567893"},
                {"Seymour DaBoy", "seymour.daboy@gmail.com", "Manager", "1234567894"}
        };

        for (String[] data : admins) {
            Admin admin = AdminFactory.createAdmin(data[0], data[1], data[2], data[3]);

            assertNotNull(admin, "Admin should be created successfully.");
            assertEquals(data[0], admin.getName());
            assertEquals(data[1], admin.getEmail());
            assertEquals(data[2], admin.getRole());
            assertEquals(data[3], admin.getContactNumber());
        }
    }
}
