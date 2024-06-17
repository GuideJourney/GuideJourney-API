package com.guidejourney.controllers;

import com.guidejourney.model.dto.ProfileSelectionDTO;
import com.guidejourney.model.entities.User;
import com.guidejourney.services.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/select")
    public ResponseEntity<User> selectProfile(@RequestBody ProfileSelectionDTO profileSelectionDTO) {
        try {
            User updatedUser = profileService.selectProfile(profileSelectionDTO);
            updatedUser.setPassword(null);  // Para no devolver la contraseña
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
