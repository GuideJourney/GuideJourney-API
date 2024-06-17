package com.guidejourney.model.entities;

import com.guidejourney.model.enums.Country;
import com.guidejourney.model.enums.InterestArea;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("MENTOR")
public class MentorProfile extends Profile {
    private Blob profilePicture;
    private String name;

    @Enumerated(EnumType.STRING)
    private Country country;

    private String company;
    private int yearsOfExperience;
    private String linkedinLink;
    private String biography;

    @ElementCollection
    @CollectionTable(name = "mentor_work_areas", joinColumns = @JoinColumn(name = "mentor_id"))
    @Column(name = "work_area")
    private List<InterestArea> workAreas;
}
