package com.guidejourney.mapper;

import com.guidejourney.model.dto.MentorDTO;
import com.guidejourney.model.dto.StudentDTO;
import com.guidejourney.model.entities.MentorProfile;
import com.guidejourney.model.entities.StudentProfile;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    @Autowired
    private ModelMapper modelMapper;

    public StudentProfile toEntity(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, StudentProfile.class);
    }

    public StudentDTO toDTO(StudentProfile studentProfile) {
        return modelMapper.map(studentProfile, StudentDTO.class);
    }

    public MentorProfile toEntity(MentorDTO mentorDTO) {
        return modelMapper.map(mentorDTO, MentorProfile.class);
    }

    public MentorDTO toDTO(MentorProfile mentorProfile) {
        return modelMapper.map(mentorProfile, MentorDTO.class);
    }
}

