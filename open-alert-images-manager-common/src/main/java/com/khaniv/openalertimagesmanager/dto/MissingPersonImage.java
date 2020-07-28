package com.khaniv.openalertimagesmanager.dto;

import com.khaniv.openalertimagesmanager.dto.enums.ImageType;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
public class MissingPersonImage {
    private Long id;

    @NonNull
    private UUID personId;

    @NonNull
    private ImageType imageType;
    private byte[] image;
}
