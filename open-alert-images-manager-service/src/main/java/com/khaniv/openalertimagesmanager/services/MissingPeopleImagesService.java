package com.khaniv.openalertimagesmanager.services;

import com.khaniv.openalertimagesmanager.entities.MissingPersonImage;
import com.khaniv.openalertimagesmanager.repositories.MissingPeopleImagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MissingPeopleImagesService {
    private final MissingPeopleImagesRepository repository;

    public List<MissingPersonImage> findMissingPersonImageDataByPersonId(UUID id) {
        return repository.findMissingPersonImageDataByPersonId(id);
    }
}
