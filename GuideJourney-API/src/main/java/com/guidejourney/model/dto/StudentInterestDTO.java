package com.guidejourney.model.dto;

import com.guidejourney.model.enums.InterestArea;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class StudentInterestDTO {
    @NotBlank
    private String email;

    private List<InterestArea> interestAreas;
}
