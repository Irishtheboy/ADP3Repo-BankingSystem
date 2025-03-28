package za.co.BankingSystem.Domain;

import java.util.Objects;

public class User {
    private final String username;
    private final String passwordHash; // Storing hashed password

    public User(String username, String password) {
        this.username = username;
        this.passwordHash = hashPassword(password); // Hash the password
    }

    private String hashPassword(String password) {
        // Implement password hashing logic
        // Example: return BCrypt.hashpw(password, BCrypt.gensalt());
        return password; // Placeholder - replace with actual hashing
    }

    public String getUsername() {
        return username;
    }

    // Removed password getter for security
    public boolean verifyPassword(String password) {
        // Implement password verification logic
        // Example: return BCrypt.checkpw(password, passwordHash);
        return password.equals(passwordHash); // Placeholder - replace with actual verification
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return username.equals(user.username) && passwordHash.equals(user.passwordHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, passwordHash);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}