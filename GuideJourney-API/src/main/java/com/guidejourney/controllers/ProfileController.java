package com.guidejourney.controllers;

import com.guidejourney.model.dto.StudentDTO;
import com.guidejourney.model.dto.MentorDTO;
import com.guidejourney.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PutMapping("/student")
    public ResponseEntity<?> updateStudentProfile(@RequestBody StudentDTO studentDTO) {
        profileService.updateStudentProfile(studentDTO);
        return ResponseEntity.ok("Student profile updated successfully");
    }

    @PutMapping("/mentor")
    public ResponseEntity<?> updateMentorProfile(@RequestBody MentorDTO mentorDTO) {
        profileService.updateMentorProfile(mentorDTO);
        return ResponseEntity.ok("Mentor profile updated successfully");
    }
}
