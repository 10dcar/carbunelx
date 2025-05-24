package org.carbunelx.service;

import org.carbunelx.dto.SignupRequest;
import org.carbunelx.model.User;
import org.carbunelx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerUser(SignupRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return false;
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        userRepository.save(user);
        return true;
    }
}