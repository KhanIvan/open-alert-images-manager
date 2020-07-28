package com.khaniv.openalertimagesmanager.controllers;

import com.khaniv.openalertimagesmanager.entities.MissingPersonImage;
import com.khaniv.openalertimagesmanager.services.MissingPeopleImagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/image")
@RequiredArgsConstructor
public class MissingPeopleImagesController {
    private final MissingPeopleImagesService missingPeopleImagesService;

    @GetMapping
    public String hello() {
        return "Hello, world!";
    }

    @GetMapping("/person/{id}")
    public List<MissingPersonImage> findMissingPersonImageDataByPersonId(@PathVariable(name = "id") UUID id) {
        return missingPeopleImagesService.findMissingPersonImageDataByPersonId(id);
    }
}
