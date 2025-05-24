package org.carbunelx.controller;

import org.carbunelx.dto.LoginRequest;
import org.carbunelx.dto.SignupRequest;
import org.carbunelx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest request) {
        System.out.println("User login");
        return true;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest request) {
        System.out.println("User signup 1");
        if (request.getUsername() == null || request.getPassword() == null) {
            return ResponseEntity.badRequest().body("Username and password are required.");
        }
        System.out.println("User signup 2");
        boolean success = userService.registerUser(request);
        if (!success) {
            System.out.println("User signup 3");
            return ResponseEntity.badRequest().body("Username already exists.");
        }
        System.out.println("User signup 4");
        return ResponseEntity.ok("User registered successfully!");
    }

    @GetMapping("/signup-form")
    public String signupForm() {
        return "signup.html";
    }
}