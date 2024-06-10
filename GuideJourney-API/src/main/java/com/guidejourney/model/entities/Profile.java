package com.guidejourney.model.entities;

import com.guidejourney.model.entities.Enum.Rol;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class Profile {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;

}
