package com.guidejourney.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.guidejourney.model.dto.MentorDTO;
import com.guidejourney.services.UserService;

@RestController
@RequestMapping("/profile/mentor")
public class MentorProfileController {

    @Autowired
    private UserService userService;

    @PostMapping("/complete")
    public ResponseEntity<String> completeMentorProfile(@RequestBody MentorDTO mentorDTO) {
        userService.completeMentorProfile(mentorDTO);
        return ResponseEntity.ok("Mentor profile completed successfully");
    }

    // Puedes agregar más endpoints específicos para mentores aquí
}

