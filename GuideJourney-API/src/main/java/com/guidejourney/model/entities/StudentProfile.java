package com.guidejourney.model.entities;

import com.guidejourney.model.enums.Country;
import jakarta.persistence.*;
import lombok.*;

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
}
