package com.khaniv.openalertimagesmanager.services;

import com.khaniv.openalertimagesmanager.dto.MissingPersonImageDto;
import com.khaniv.openalertimagesmanager.entities.MissingPersonImage;
import com.khaniv.openalertimagesmanager.mappers.MissingPersonImageMapper;
import com.khaniv.openalertimagesmanager.repositories.MissingPeopleImagesRepository;
import com.khaniv.openalertphotostorage.api.PhotoStorageApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MissingPeopleImagesService {
    private final MissingPeopleImagesRepository repository;
    private final MissingPersonImageMapper mapper;
    private final PhotoStorageApi photoStorageApi;

    public MissingPersonImageDto findMissingPersonImageById(Long id) {
        MissingPersonImageDto missingPersonImageDto = mapper.toDto(repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("No images found by ID " + id)));
        MissingPersonImageDto image = photoStorageApi.findLostPersonImage(missingPersonImageDto);
        missingPersonImageDto.setImage(image.getImage());
        return missingPersonImageDto;
    }

    public List<MissingPersonImageDto> findMissingPersonImagesByPersonId(UUID id) {
        List<MissingPersonImage> missingPersonImage = repository.findMissingPersonImageDataByPersonId(id);
        return mapper.toDto(missingPersonImage);
    }

    public MissingPersonImageDto save(MissingPersonImageDto missingPersonImage) {
        MissingPersonImageDto savedImage = mapper.toDto(repository.save(mapper.toEntity(missingPersonImage)));
        savedImage.setImage(missingPersonImage.getImage());
        photoStorageApi.storeLostPersonImage(savedImage);
        return savedImage;
    }
}
