package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminRepositoryTest {

    private AdminRepository adminRepo;
    private Admin admin;

    @BeforeEach
    void setUp() {
        adminRepo = AdminRepository.getRepository();
        admin = new Admin.Builder()
                .setAdminID("A001")
                .setName("Naqeebah Khan")
                .setEmail("naqeebah.khan@gmail.com")
                .setRole("Manager")
                .setContactNumber("1234567890")
                .build();
        adminRepo.create(admin);
    }

    @Test
    void create() {
        Admin newAdmin = new Admin.Builder()
                .setAdminID("A002")
                .setName("Rorisang Simphiwe")
                .setEmail("rorisang.simphiwe@gmail.com")
                .setRole("Admin")
                .setContactNumber("1234567891")
                .build();

        Admin savedAdmin = adminRepo.create(newAdmin);
        assertNotNull(savedAdmin);
        assertEquals(newAdmin.getAdminID(), savedAdmin.getAdminID());
    }

    @Test
    void read() {
        Admin foundAdmin = adminRepo.read(admin.getAdminID());
        assertNotNull(foundAdmin);
        assertEquals(admin.getAdminID(), foundAdmin.getAdminID());
    }

    @Test
    void update() {
        Admin updatedAdmin = new Admin.Builder()
                .setAdminID(admin.getAdminID())
                .setName("Updated Naqeebah Khan")
                .setEmail("updated.naqeebah.khan@gmail.com")
                .setRole("Head Manager")
                .setContactNumber("111222333")
                .build();

        Admin result = adminRepo.update(updatedAdmin);

        assertNotNull(result);
        assertEquals("Updated Naqeebah Khan", result.getName());

        System.out.println(updatedAdmin);
    }

    @Test
    void delete() {
        boolean success = adminRepo.delete(admin.getAdminID());
        assertTrue(success);

        Admin deletedAdmin = adminRepo.read(admin.getAdminID());
        assertNull(deletedAdmin);
    }

    @Test
    void getAll() {
        assertNotNull(adminRepo.getAll());
        assertFalse(adminRepo.getAll().isEmpty());
    }
}
