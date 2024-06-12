package com.guidejourney.model.entities;

import com.guidejourney.exceptions.MaxInterestAreasExceededException;
import com.guidejourney.model.entities.Enum.Country;
import com.guidejourney.model.entities.Enum.InterestArea;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("STUDENT")
public class StudentProfile extends Profile {
    private Blob profilePicture;
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
