package com.guidejourney.model.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Administrador extends Profile {

    private String email = "admin@gmail.com";

    private String password = "admin0024";

}




