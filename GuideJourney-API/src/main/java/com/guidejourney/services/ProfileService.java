package com.guidejourney.services;

import com.guidejourney.exceptions.InvalidProfileTypeException;
import com.guidejourney.exceptions.UserNotFoundException;
import com.guidejourney.model.dto.ProfileSelectionDTO;
import com.guidejourney.model.dto.StudentDTO;
import com.guidejourney.model.dto.StudentInterestDTO;
import com.guidejourney.model.entities.StudentProfile;
import com.guidejourney.model.entities.MentorProfile;
import com.guidejourney.model.entities.User;
import com.guidejourney.model.enums.Rol;
import com.guidejourney.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private UserRepository userRepository;

    public User selectProfile(ProfileSelectionDTO profileSelectionDTO) throws UserNotFoundException, InvalidProfileTypeException {
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

    public User updateStudentProfileBasicInfo(StudentDTO studentDTO) throws UserNotFoundException {
        User user = userRepository.findByEmail(studentDTO.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        if (user.getProfile() instanceof StudentProfile) {
            StudentProfile studentProfile = (StudentProfile) user.getProfile();
            studentProfile.setName(studentDTO.getName());
            studentProfile.setCountry(studentDTO.getCountry());
            studentProfile.setCompanyOrSchool(studentDTO.getCompanyOrSchool());
            studentProfile.setBiography(studentDTO.getBiography());
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Profile is not of type STUDENT");
        }
    }

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
