package com.guidejourney.model.dto;

import com.guidejourney.model.enums.Country;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentDTO {
    @NotBlank
    private String email;

    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    private Country country;

    @NotBlank
    private String companyOrSchool;

    @NotBlank
    private String biography;
}
