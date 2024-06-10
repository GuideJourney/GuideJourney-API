package com.guidejourney.model.dto;

import java.sql.Blob;
import java.util.List;

import com.guidejourney.model.entities.Enum.Country;
import com.guidejourney.model.entities.Enum.InterestArea;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class MentorDTO {

    private Blob profilePicture;

    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    private Country country; 
 
    private List<InterestArea> workAreas;

    @NotBlank
    private String company;

    @Positive
    private int yearsOfExperience;

    @NotBlank
    private String linkedinLink;

    @NotBlank
    private String biography;

}
