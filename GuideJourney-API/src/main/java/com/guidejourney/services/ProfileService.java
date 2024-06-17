package com.guidejourney.services;

import com.guidejourney.model.dto.ProfileSelectionDTO;
import com.guidejourney.model.entities.StudentProfile;
import com.guidejourney.model.entities.MentorProfile;
import com.guidejourney.model.entities.User;
import com.guidejourney.model.enums.Rol;
import com.guidejourney.repositories.UserRepository;
import com.guidejourney.exceptions.UserNotFoundException;
import com.guidejourney.exceptions.InvalidProfileTypeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private UserRepository userRepository;

    public User selectProfile(ProfileSelectionDTO profileSelectionDTO) throws Exception {
        User user = userRepository.findByEmail(profileSelectionDTO.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        
        if ("STUDENT".equalsIgnoreCase(profileSelectionDTO.getProfileType())) {
            StudentProfile studentProfile = new StudentProfile();
            studentProfile.setRol(Rol.ESTUDIANTE);
            user.setProfile(studentProfile);
        } else if ("MENTOR".equalsIgnoreCase(profileSelectionDTO.getProfileType())) {
            MentorProfile mentorProfile = new MentorProfile();
            mentorProfile.setRol(Rol.MENTOR);
            user.setProfile(mentorProfile);
        } else {
            throw new InvalidProfileTypeException("Invalid profile type");
        }

        return userRepository.save(user);
    }
}
