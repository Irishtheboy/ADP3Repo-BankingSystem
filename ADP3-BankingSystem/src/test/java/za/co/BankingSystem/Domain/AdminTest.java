package za.co.BankingSystem.Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {
    @Test
    void testAdminBuilder() {
        // Arrange: Create multiple Admin objects using the Builder pattern
        Admin admin1 = new Admin.Builder()
                .setAdminID("A001")
                .setName("John Doe")
                .setEmail("john.doe@example.com")
                .setRole("Manager")
                .setContactNumber("1234567890")
                .build();

        Admin admin2 = new Admin.Builder()
                .setAdminID("A002")
                .setName("Jane Smith")
                .setEmail("jane.smith@example.com")
                .setRole("Supervisor")
                .setContactNumber("9876543210")
                .build();

        Admin admin3 = new Admin.Builder()
                .setAdminID("A003")
                .setName("Alice Brown")
                .setEmail("alice.brown@example.com")
                .setRole("Administrator")
                .setContactNumber("5556667777")
                .build();

        Admin admin4 = new Admin.Builder()
                .setAdminID("A004")
                .setName("Bob White")
                .setEmail("bob.white@example.com")
                .setRole("Assistant Manager")
                .setContactNumber("1112223333")
                .build();

        Admin admin5 = new Admin.Builder()
                .setAdminID("A005")
                .setName("Charlie Green")
                .setEmail("charlie.green@example.com")
                .setRole("HR")
                .setContactNumber("9998887777")
                .build();

        // Act & Assert: Check if each Admin ID matches the expected value
        assertEquals("A001", admin1.adminID);
        assertEquals("A002", admin2.adminID);
        assertEquals("A003", admin3.adminID);
        assertEquals("A004", admin4.adminID);
        assertEquals("A005", admin5.adminID);
    }

}