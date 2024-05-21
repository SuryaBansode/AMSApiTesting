package com.example.apiTesting;

import com.example.apiTesting.model.User;
import com.example.apiTesting.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class DataLoader {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void loadData() {
        // Check if users already exist
        if (userRepository.count() == 0) {
            // Create users
            User user1 = new User();
            user1.setUsername("user1");
            user1.setPassword(passwordEncoder.encode("password1"));

            User user2 = new User();
            user2.setUsername("user2");
            user2.setPassword(passwordEncoder.encode("password2"));

            // Save users to the database
            userRepository.save(user1);
            userRepository.save(user2);
        }
    }
}
