package com.khaniv.openalertimagesmanager.services;

import com.khaniv.openalertimagesmanager.dto.MissingPersonImageDto;
import com.khaniv.openalertimagesmanager.entities.MissingPersonImage;
import com.khaniv.openalertimagesmanager.mappers.MissingPersonImageMapper;
import com.khaniv.openalertimagesmanager.repositories.MissingPeopleImagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MissingPeopleImagesService {
    private final MissingPeopleImagesRepository repository;
    private final MissingPersonImageMapper mapper;

    public MissingPersonImageDto findMissingPersonImageById(Long id) {
        return mapper.toDto(repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No images found by ID " + id)));
    }

    public List<MissingPersonImageDto> findMissingPersonImageByPersonId(UUID id) {
        List<MissingPersonImage> missingPersonImage = repository.findMissingPersonImageDataByPersonId(id);
        List<MissingPersonImageDto> missingPersonImageDtos = mapper.toDto(missingPersonImage);
        return missingPersonImageDtos;
    }

    public MissingPersonImageDto save(MissingPersonImageDto missingPersonImage) {
        return mapper.toDto(repository.save(mapper.toEntity(missingPersonImage)));
    }
}
