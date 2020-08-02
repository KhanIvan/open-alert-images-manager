package com.khaniv.openalertimagesmanager.dto;

import com.khaniv.openalertimagesmanager.dto.enums.ImageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class MissingPersonImageDto {
    private Long id;
    @NonNull
    private UUID personId;
    @NonNull
    private ImageType type;
    private byte[] image;
}
