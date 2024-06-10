package com.guidejourney.model.entities;

import java.sql.Blob;
import java.util.List;

import com.guidejourney.exceptions.MaxInterestAreasExceededException;
import com.guidejourney.model.entities.Enum.Country;
import com.guidejourney.model.entities.Enum.InterestArea;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MentorProfile extends Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    public void setWorkAreas(List<InterestArea> workAreas) {
        if (workAreas.size() > 5) {
            throw new MaxInterestAreasExceededException();
        }
        this.workAreas = workAreas;
    }
}
