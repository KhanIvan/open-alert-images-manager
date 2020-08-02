package com.khaniv.openalertimagesmanager.mappers;

import com.khaniv.openalertimagesmanager.dto.MissingPersonImageDto;
import com.khaniv.openalertimagesmanager.entities.MissingPersonImage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MissingPersonImageMapper {
    MissingPersonImage toEntity(MissingPersonImageDto dto);

    List<MissingPersonImage> toEntity(List<MissingPersonImageDto> dtos);

    MissingPersonImageDto toDto(MissingPersonImage entity);

    List<MissingPersonImageDto> toDto(List<MissingPersonImage> entities);
}
