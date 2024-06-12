package com.guidejourney.model.entities;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("ADMIN")
public class Administrador extends Profile {

    @Column(unique = true)
    @Email
    private String email = "adming@gmail.com";

    @Column(nullable = false)
    private String password = "admin2024";
}




