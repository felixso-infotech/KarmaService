package com.lxisoft.service.mapper;

import com.lxisoft.domain.*;
import com.lxisoft.service.dto.MediaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Media and its DTO MediaDTO.
 */
@Mapper(componentModel = "spring", uses = {ActivityMapper.class, CompletedActivityMapper.class})
public interface MediaMapper extends EntityMapper<MediaDTO, Media> {

    @Mapping(source = "activity.id", target = "activityId")
    @Mapping(source = "completedActivity.id", target = "completedActivityId")
    MediaDTO toDto(Media media);

    @Mapping(source = "activityId", target = "activity")
    @Mapping(source = "completedActivityId", target = "completedActivity")
    Media toEntity(MediaDTO mediaDTO);

    default Media fromId(Long id) {
        if (id == null) {
            return null;
        }
        Media media = new Media();
        media.setId(id);
        return media;
    }
}
