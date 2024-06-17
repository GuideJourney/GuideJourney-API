package com.guidejourney.services;

import com.guidejourney.exceptions.UserNotFoundException;
import com.guidejourney.model.dto.StudentInterestDTO;
import com.guidejourney.model.entities.StudentProfile;
import com.guidejourney.model.entities.User;
import com.guidejourney.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private UserRepository userRepository;

    public User updateStudentInterests(StudentInterestDTO studentInterestDTO) throws UserNotFoundException {
        User user = userRepository.findByEmail(studentInterestDTO.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (user.getProfile() instanceof StudentProfile) {
            StudentProfile studentProfile = (StudentProfile) user.getProfile();
            studentProfile.setInterestAreas(studentInterestDTO.getInterestAreas());
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Profile is not of type STUDENT");
        }
    }
}
