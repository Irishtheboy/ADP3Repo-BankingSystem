package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Admin;
import java.util.ArrayList;
import java.util.List;

/**
 * AdminRepository.java
 * Repository class for Admin
 *
 * Author: Franco Lukhele (222462914)
 * 28 March 2025
 */

public class AdminRepository {
    private static AdminRepository repository = null;
    private List<Admin> adminList;

    private AdminRepository() {
        adminList = new ArrayList<>();
    }

    public static AdminRepository getRepository() {
        if (repository == null) {
            repository = new AdminRepository();
        }
        return repository;
    }

    public Admin create(Admin admin) {
        boolean success = adminList.add(admin);
        return success ? admin : null;
    }

    public Admin read(String adminID) {
        return adminList.stream()
                .filter(admin -> admin.getAdminID().equals(adminID))
                .findFirst()
                .orElse(null);
    }

    public Admin update(Admin admin) {
        Admin existingAdmin = read(admin.getAdminID());
        if (existingAdmin != null) {
            delete(admin.getAdminID());
            adminList.add(admin);
            return admin;
        }
        return null;
    }

    public boolean delete(String adminID) {
        Admin adminToDelete = read(adminID);
        if (adminToDelete != null) {
            adminList.remove(adminToDelete);
            return true;
        }
        return false;
    }

    public List<Admin> getAll() {
        return adminList;
    }
}
