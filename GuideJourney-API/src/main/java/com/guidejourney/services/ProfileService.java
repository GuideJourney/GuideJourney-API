package com.guidejourney.services;

import com.guidejourney.model.dto.StudentDTO;
import com.guidejourney.model.dto.MentorDTO;
import com.guidejourney.model.entities.StudentProfile;
import com.guidejourney.model.entities.MentorProfile;
import com.guidejourney.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void updateStudentProfile(StudentDTO studentDTO) {
        StudentProfile studentProfile = modelMapper.map(studentDTO, StudentProfile.class);
        profileRepository.save(studentProfile);
    }

    public void updateMentorProfile(MentorDTO mentorDTO) {
        MentorProfile mentorProfile = modelMapper.map(mentorDTO, MentorProfile.class);
        profileRepository.save(mentorProfile);
    }
}
