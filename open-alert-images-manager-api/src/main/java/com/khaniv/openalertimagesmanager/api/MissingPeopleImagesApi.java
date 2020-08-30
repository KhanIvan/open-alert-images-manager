package com.khaniv.openalertimagesmanager.api;

import com.khaniv.openalertimagesmanager.constants.MissingPeopleImagesPaths;
import com.khaniv.openalertimagesmanager.dto.MissingPersonImageDto;
import lombok.NonNull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient("open-alert-images-manager")
@Service
@SuppressWarnings("unused")
public interface MissingPeopleImagesApi {
    @GetMapping(MissingPeopleImagesPaths.CONTROLLER + MissingPeopleImagesPaths.FIND_BY_PERSON_ID)
    List<MissingPersonImageDto> findMissingPersonImageDataByPersonId(@PathVariable(name = "id") @NonNull UUID id);

    @GetMapping(MissingPeopleImagesPaths.CONTROLLER + MissingPeopleImagesPaths.ID)
    MissingPersonImageDto findMissingPersonImageById(@PathVariable(name = "id") @NonNull Long id);

    @PostMapping
    MissingPersonImageDto saveMissingPersonImage(@RequestBody @NonNull MissingPersonImageDto missingPersonImage);
}
