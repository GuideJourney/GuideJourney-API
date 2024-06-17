package com.guidejourney.model.entities;

import com.guidejourney.exceptions.MaxInterestAreasExceededException;
import com.guidejourney.model.enums.Country;
import com.guidejourney.model.enums.InterestArea;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("STUDENT")
public class StudentProfile extends Profile {
    private String name;

    @Enumerated(EnumType.STRING)
    private Country country;

    private String companyOrSchool;
    private String biography;

    @ElementCollection
    @CollectionTable(name = "student_interest_areas", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "interest_area")
    private List<InterestArea> interestAreas;

    public void setInterestAreas(List<InterestArea> interestAreas) {
        if (interestAreas.size() > 5) {
            throw new MaxInterestAreasExceededException();
        }
        this.interestAreas = interestAreas;
    }
}
