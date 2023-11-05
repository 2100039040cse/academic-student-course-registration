package net.javaguides.springboot.service;

import javax.annotation.PostConstruct;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;

import java.util.Arrays;
import net.javaguides.springboot.model.Role; 
@Service
public class AdminInitService {
	private UserService userService;
	 private UserRepository userRepository;


    
    public AdminInitService(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        // Check if the user already exists
        User existingUser = userRepository.findByEmail("admin@example.com");
        if (existingUser != null) {
            // If the user exists, delete it
            userRepository.delete(existingUser);
        }

        // Create a new user
        String plainPassword = "adminPassword";
        String encodedPassword = new BCryptPasswordEncoder().encode(plainPassword);

        User adminUser = new User("Admin", "Admin", "admin@example.com", encodedPassword, "admin", "1234567890", "Admin Address", Arrays.asList(new Role("ROLE_ADMIN")));
        userService.saveAdmin(adminUser);
    }
}
