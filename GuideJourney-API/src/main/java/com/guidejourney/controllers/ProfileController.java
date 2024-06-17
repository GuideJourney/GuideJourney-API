package com.guidejourney.controllers;

import com.guidejourney.exceptions.UserNotFoundException;
import com.guidejourney.model.dto.StudentInterestDTO;
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

    @PutMapping("/student/interests")
    public ResponseEntity<User> updateStudentInterests(@RequestBody StudentInterestDTO studentInterestDTO) {
        try {
            User updatedUser = profileService.updateStudentInterests(studentInterestDTO);
            updatedUser.setPassword(null);  // Para no devolver la contraseña
            return ResponseEntity.ok(updatedUser);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
