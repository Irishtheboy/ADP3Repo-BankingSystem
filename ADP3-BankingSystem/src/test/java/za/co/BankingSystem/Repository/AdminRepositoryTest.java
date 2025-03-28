// Naqeebah Khan 219099073
package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Admin;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Franco Lukhele
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminRepositoryTest {

    private static AdminRepository adminRepo = AdminRepository.getRepository();

    private static Admin admin1 = new Admin.Builder()
            .setAdminID("A001")
            .setName("Naqeebah Khan")
            .setEmail("naqeebah.khan@gmail.com")
            .setRole("Manager")
            .setContactNumber("1234567890")
            .build();

    private static Admin admin2 = new Admin.Builder()
            .setAdminID("A002")
            .setName("Rorisang Simphiwe")
            .setEmail("rorisang.simphiwe@gmail.com")
            .setRole("Admin")
            .setContactNumber("1234567891")
            .build();

    @Test
    @Order(1)
    public void testCreateAdmin() {
        Admin createdAdmin = adminRepo.create(admin1);
        assertNotNull(createdAdmin);
        assertEquals("A001", createdAdmin.getAdminID());
        System.out.println("Created Admin: " + createdAdmin.toString());
    }

    @Test
    @Order(2)
    public void testReadAdmin() {
        Admin foundAdmin = adminRepo.read("A001");
        assertNotNull(foundAdmin);
        assertEquals("Naqeebah Khan", foundAdmin.getName());
        System.out.println("Read Admin: " + foundAdmin.toString());
    }

    @Test
    @Order(3)
    public void testUpdateAdmin() {
        admin1 = new Admin.Builder()
                .setAdminID("A001")
                .setName("Updated Naqeebah Khan")
                .setEmail("updated.naqeebah.khan@gmail.com")
                .setRole("Head Manager")
                .setContactNumber("111222333")
                .build();

        Admin updatedAdmin = adminRepo.update(admin1);
        assertNotNull(updatedAdmin);
        assertEquals("Updated Naqeebah Khan", updatedAdmin.getName());
        System.out.println("Updated Admin: " + updatedAdmin.toString());
    }

    @Test
    @Order(4)
    public void testDeleteAdmin() {
        boolean isDeleted = adminRepo.delete("A001");
        assertTrue(isDeleted);
        Admin deletedAdmin = adminRepo.read("A001");
        assertNull(deletedAdmin);
        System.out.println("Deleted Admin with ID A001");
    }

    @Test
    @Order(5)
    public void testGetAllAdmins() {
        adminRepo.create(admin2);
        assertEquals(1, adminRepo.getAll().size());
        System.out.println("Total Admins: " + adminRepo.getAll().size());
    }
}
