package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Admin;
import za.co.BankingSystem.Util.Helper;
/**
 * AdminFactory class to construct Admin objects.
 * This class uses the Builder pattern for constructing Admin objects.
 * It also performs validation on the input fields before creating an Admin.
 *
 * Author: Franco Lukhele
 */
public class AdminFactory {
    public static Admin createAdmin(String name, String email, String role, String contactNumber) {
        // Generate unique admin ID
        String adminID = Helper.generateID();

        // Validate inputs using Helper class
        if (Helper.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Admin name cannot be empty");
        }
        if (!Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (Helper.isNullOrEmpty(role)) {
            throw new IllegalArgumentException("Role cannot be empty");
        }
        if (!Helper.isValidPhoneNumber(contactNumber)) {
            throw new IllegalArgumentException("Invalid contact number");
        }

        return new Admin.Builder()
                .setAdminID(adminID)
                .setName(name)
                .setEmail(email)
                .setRole(role)
                .setContactNumber(contactNumber)
                .build();
    }
}
