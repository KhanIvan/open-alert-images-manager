package com.khaniv.openalertimagesmanager.controllers;

import com.khaniv.openalertimagesmanager.constants.MissingPeopleImagesPaths;
import com.khaniv.openalertimagesmanager.dto.MissingPersonImageDto;
import com.khaniv.openalertimagesmanager.services.MissingPeopleImagesService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(MissingPeopleImagesPaths.CONTROLLER)
@RequiredArgsConstructor
@Log4j2
@SuppressWarnings("unused")
public class MissingPeopleImagesController {
    private final MissingPeopleImagesService missingPeopleImagesService;

    @GetMapping(MissingPeopleImagesPaths.ID)
    public MissingPersonImageDto findMissingPersonImageById(@PathVariable(name = "id") @NonNull Long id) {
        log.info("Find missing person image by ID: {}", id);
        return missingPeopleImagesService.findMissingPersonImageById(id);
    }

    @GetMapping(MissingPeopleImagesPaths.FIND_BY_PERSON_ID)
    public List<MissingPersonImageDto> findMissingPersonImageByPersonId(@PathVariable(name = "id") @NonNull UUID id) {
        log.info("Find missing person images by person ID: {}", id);
        return missingPeopleImagesService.findMissingPersonImageByPersonId(id);
    }

    @PostMapping
    public MissingPersonImageDto saveMissingPersonImage(@RequestBody @NonNull MissingPersonImageDto missingPersonImage) {
        log.info("Save missing person image");
        return missingPeopleImagesService.save(missingPersonImage);
    }
}
