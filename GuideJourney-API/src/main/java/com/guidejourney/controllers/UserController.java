package com.guidejourney.controllers;

import com.guidejourney.model.dto.LoginDTO;
import com.guidejourney.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody LoginDTO loginDTO) {
        userService.registerUser(loginDTO);
        return ResponseEntity.ok("User registered successfully");
    }
}
