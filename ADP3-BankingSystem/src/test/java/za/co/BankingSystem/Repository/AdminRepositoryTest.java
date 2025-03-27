package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Admin;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminRepositoryTest {

    private static AdminRepository adminRepo = AdminRepository.getRepository();

    private static Admin admin1 = new Admin.Builder()
            .setAdminID("A001")
            .setName("Admin One")
            .setEmail("admin1@example.com")
            .setRole("Manager")
            .setContactNumber("123456789")
            .build();

    private static Admin admin2 = new Admin.Builder()
            .setAdminID("A002")
            .setName("Admin Two")
            .setEmail("admin2@example.com")
            .setRole("Supervisor")
            .setContactNumber("987654321")
            .build();

    @Test
    @Order(1)
    public void testCreateAdmin() {
        Admin createdAdmin = adminRepo.create(admin1);
        assertNotNull(createdAdmin);
        assertEquals("A001", createdAdmin.adminID);
        System.out.println("Created Admin: " + createdAdmin.toString());
    }

    @Test
    @Order(2)
    public void testReadAdmin() {
        Admin foundAdmin = adminRepo.read("A001");
        assertNotNull(foundAdmin);
        assertEquals("Admin One", foundAdmin.getName());
        System.out.println("Read Admin: " + foundAdmin.toString());
    }

    @Test
    @Order(3)
    public void testUpdateAdmin() {
        admin1 = new Admin.Builder()
                .setAdminID("A001")
                .setName("Updated Admin One")
                .setEmail("updatedadmin1@example.com")
                .setRole("Head Manager")
                .setContactNumber("111222333")
                .build();

        Admin updatedAdmin = adminRepo.update(admin1);
        assertNotNull(updatedAdmin);
        assertEquals("Updated Admin One", updatedAdmin.getName());
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
