package com.guidejourney.mapper;

import com.guidejourney.model.dto.LoginDTO;
import com.guidejourney.model.dto.StudentDTO;
import com.guidejourney.model.dto.MentorDTO;
import com.guidejourney.model.entities.StudentProfile;
import com.guidejourney.model.entities.MentorProfile;
import com.guidejourney.model.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User loginDTOToUser(LoginDTO loginDTO) {
        return modelMapper.map(loginDTO, User.class);
    }

    public StudentProfile studentDTOToStudentProfile(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, StudentProfile.class);
    }

    public MentorProfile mentorDTOToMentorProfile(MentorDTO mentorDTO) {
        return modelMapper.map(mentorDTO, MentorProfile.class);
    }

    public void updateStudentProfileFromDTO(StudentDTO studentDTO, StudentProfile profile) {
        modelMapper.map(studentDTO, profile);
    }

    public void updateMentorProfileFromDTO(MentorDTO mentorDTO, MentorProfile profile) {
        modelMapper.map(mentorDTO, profile);
    }
}
