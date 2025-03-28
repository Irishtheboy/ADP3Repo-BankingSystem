package za.co.BankingSystem.Service;

import za.co.BankingSystem.Domain.User;
import za.co.BankingSystem.Repository.UserRepository;

import java.util.Objects;

public class LoginService {
    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        
        // If user is found, verify the password using the hashing method
        if (user != null) {
            return verifyPassword(password, user);
        }
        
        return false; // Username does not exist
    }

    private boolean verifyPassword(String plainPassword, User user) {
        // Implement password verification logic
        // Example: return BCrypt.checkpw(plainPassword, user.getPassword());
        return plainPassword.equals(user.getPasswordHash()); // Assuming a getter for the hashed password
    }
}