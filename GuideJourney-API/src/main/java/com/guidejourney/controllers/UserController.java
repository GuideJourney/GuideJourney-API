package com.guidejourney.controllers;

import com.guidejourney.exceptions.UserAlreadyExistsException;
import com.guidejourney.model.dto.LoginDTO;
import com.guidejourney.model.entities.User;
import com.guidejourney.services.UserService;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody LoginDTO loginDTO) {
        try {
            User registeredUser = userService.registerUser(loginDTO);
            // Excluir la contraseña del objeto devuelto
            registeredUser.setPassword(null);
            return ResponseEntity.ok(registeredUser);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }
}
