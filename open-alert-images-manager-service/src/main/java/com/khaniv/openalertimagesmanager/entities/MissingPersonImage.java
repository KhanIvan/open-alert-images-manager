package com.khaniv.openalertimagesmanager.entities;

import com.khaniv.openalertimagesmanager.dto.enums.ImageType;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "missing_people_image_data", schema = "images")
@Data
public class MissingPersonImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Basic
    @Column(name = "person_id", columnDefinition = "uuid")
    private UUID personId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private ImageType type;
}
