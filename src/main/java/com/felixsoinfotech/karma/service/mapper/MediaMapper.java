package com.felixsoinfotech.karma.service.mapper;

import com.felixsoinfotech.karma.domain.*;
import com.felixsoinfotech.karma.service.dto.MediaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Media and its DTO MediaDTO.
 */
@Mapper(componentModel = "spring", uses = {CommittedActivityMapper.class, CompletedChallengeMapper.class})
public interface MediaMapper extends EntityMapper<MediaDTO, Media> {

    @Mapping(source = "committedActivity.id", target = "committedActivityId")
    @Mapping(source = "completedChallenge.id", target = "completedChallengeId")
    MediaDTO toDto(Media media);

    @Mapping(source = "committedActivityId", target = "committedActivity")
    @Mapping(source = "completedChallengeId", target = "completedChallenge")
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
