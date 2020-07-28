package com.khaniv.openalertimagesmanager.repositories;

import com.khaniv.openalertimagesmanager.entities.MissingPersonImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MissingPeopleImagesRepository extends JpaRepository<MissingPersonImage, Long> {
    List<MissingPersonImage> findMissingPersonImageDataByPersonId(UUID personId);
}
