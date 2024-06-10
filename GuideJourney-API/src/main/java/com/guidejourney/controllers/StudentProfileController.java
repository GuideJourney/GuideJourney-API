package com.guidejourney.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.guidejourney.model.dto.StudentDTO;
import com.guidejourney.services.UserService;

@RestController
@RequestMapping("/profile/student")
public class StudentProfileController {

    @Autowired
    private UserService userService;

    @PostMapping("/complete")
    public ResponseEntity<String> completeStudentProfile(@RequestBody StudentDTO studentDTO) {
        userService.completeStudentProfile(studentDTO);
        return ResponseEntity.ok("Student profile completed successfully");
    }

    // Puedes agregar más endpoints específicos para estudiantes aquí
}
