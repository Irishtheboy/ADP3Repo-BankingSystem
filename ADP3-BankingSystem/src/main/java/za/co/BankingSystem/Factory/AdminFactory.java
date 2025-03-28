package za.co.BankingSystem.Factory;

import za.co.BankingSystem.Domain.Admin;
import za.co.BankingSystem.Util.Helper;
/**
 * Adminfactory.java
 * Admin Factory class
 *
 * Author: Franco Lukhele(222462914)
 * 28 March 2025
 */
public class AdminFactory {
    public static Admin createAdmin(String name, String email, String role, String contactNumber) {

        String adminID = Helper.generateID();


        if (Helper.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (!Helper.isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (Helper.isNullOrEmpty(role)) {
            throw new IllegalArgumentException("Role cannot be empty");
        }
        if (!Helper.isValidPhoneNumber(contactNumber)) {
            throw new IllegalArgumentException("Invalid phone number format");
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
