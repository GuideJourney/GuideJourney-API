

package com.guidejourney.model.dto;    

import java.sql.Blob;
import java.util.List;

import com.guidejourney.model.entities.Enum.Country;
import com.guidejourney.model.entities.Enum.InterestArea;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class ProfileResponseDTO {
    private Blob profilePicture;
    private String name;

    @Enumerated(EnumType.STRING)
    private Country country; 

    private List<InterestArea> areas;

    private String companyOrSchool;
    private String biography;

    private String linkedinLink;
    private int yearsOfExperience;

    private String role; // Para indicar si es STUDENT o MENTOR
}
