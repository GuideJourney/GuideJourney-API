package com.guidejourney.model.dto;

import com.guidejourney.model.entities.Enum.Country;
import com.guidejourney.model.entities.Enum.InterestArea;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class MentorDTO {
    @NotBlank
    private String email;

    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    private Country country;

    private List<InterestArea> workAreas;

    @NotBlank
    private String company;

    private int yearsOfExperience;

    @NotBlank
    private String linkedinLink;

    @NotBlank
    private String biography;
}
