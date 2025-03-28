package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Admin;
import java.util.ArrayList;
import java.util.List;

/**
 * AdminRepo.java
 * Admin Repo class
 *
 * Author: Franco Lukhele(222462914)
 * 28 March 2025
 */
public class AdminRepository implements IAdminRepository {
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

    @Override
    public Admin create(Admin admin) {
        boolean success = adminList.add(admin);
        if (success) {
            return admin;
        }
        return null;
    }

    @Override
    public Admin read(String id) {
        for (Admin a : adminList) {
            if (a.getAdminID().equals(id)) {
                return a;
            }
        }
        return null;
    }

    @Override
    public Admin update(Admin admin) {
        Admin oldAdmin = read(admin.getAdminID());
        if (oldAdmin == null) {
            return null;
        }
        boolean success = delete(admin.getAdminID());
        if (success) {
            if (adminList.add(admin)) {
                return admin;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Admin adminToDelete = read(id);
        if (adminToDelete == null) {
            return false;
        }
        return adminList.remove(adminToDelete);
    }

    @Override
    public List<Admin> getAll() {
        return adminList;
    }
}
