package com.guidejourney.services;

import com.guidejourney.exceptions.UserNotFoundException;
import com.guidejourney.exceptions.UserAlreadyExistsException;
import com.guidejourney.exceptions.MaxInterestAreasExceededException;
import com.guidejourney.model.dto.LoginDTO;
import com.guidejourney.model.dto.MentorDTO;
import com.guidejourney.model.dto.StudentDTO;
import com.guidejourney.model.entities.*;
import com.guidejourney.model.entities.Enum.Rol;
import com.guidejourney.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(String email, String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new UserAlreadyExistsException("User with this email already exists");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    public Optional<User> login(LoginDTO loginDTO) {
        Optional<User> userOptional = userRepository.findByEmail(loginDTO.getEmail());
        if (userOptional.isPresent() && passwordEncoder.matches(loginDTO.getPassword(), userOptional.get().getPassword())) {
            return userOptional;
        } else {
            return Optional.empty();
        }
    }

    public void completeStudentProfile(StudentDTO studentDTO) {
        // Obtener el usuario autenticado
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        // Crear y guardar el perfil de estudiante
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setProfilePicture(studentDTO.getProfilePicture());
        studentProfile.setName(studentDTO.getName());
        studentProfile.setCountry(studentDTO.getCountry());
        if (studentDTO.getInterestAreas().size() > 5) {
            throw new MaxInterestAreasExceededException();
        }
        studentProfile.setInterestAreas(studentDTO.getInterestAreas());
        studentProfile.setCompanyOrSchool(studentDTO.getCompanyOrSchool());
        studentProfile.setBiography(studentDTO.getBiography());
        studentProfile.setRol(Rol.ESTUDIANTE);

        // Asociar el perfil de estudiante al usuario y guardar
        user.setProfile(studentProfile);
        userRepository.save(user);
    }

    public void completeMentorProfile(MentorDTO mentorDTO) {
        // Obtener el usuario autenticado
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        // Crear y guardar el perfil de mentor
        MentorProfile mentorProfile = new MentorProfile();
        mentorProfile.setProfilePicture(mentorDTO.getProfilePicture());
        mentorProfile.setName(mentorDTO.getName());
        mentorProfile.setCountry(mentorDTO.getCountry());
        if (mentorDTO.getWorkAreas().size() > 5) {
            throw new MaxInterestAreasExceededException();
        }
        mentorProfile.setWorkAreas(mentorDTO.getWorkAreas());
        mentorProfile.setCompany(mentorDTO.getCompany());
        mentorProfile.setYearsOfExperience(mentorDTO.getYearsOfExperience());
        mentorProfile.setLinkedinLink(mentorDTO.getLinkedinLink());
        mentorProfile.setBiography(mentorDTO.getBiography());
        mentorProfile.setRol(Rol.MENTOR);

        // Asociar el perfil de mentor al usuario y guardar
        user.setProfile(mentorProfile);
        userRepository.save(user);
    }
}




