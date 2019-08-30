package com.felixsoinfotech.karma.service.mapper;

import com.felixsoinfotech.karma.domain.*;
import com.felixsoinfotech.karma.service.dto.IntroductionStoryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity IntroductionStory and its DTO IntroductionStoryDTO.
 */
@Mapper(componentModel = "spring", uses = {ActivityMapper.class})
public interface IntroductionStoryMapper extends EntityMapper<IntroductionStoryDTO, IntroductionStory> {

    @Mapping(source = "activity.id", target = "activityId")
    IntroductionStoryDTO toDto(IntroductionStory introductionStory);

    @Mapping(source = "activityId", target = "activity")
    IntroductionStory toEntity(IntroductionStoryDTO introductionStoryDTO);

    default IntroductionStory fromId(Long id) {
        if (id == null) {
            return null;
        }
        IntroductionStory introductionStory = new IntroductionStory();
        introductionStory.setId(id);
        return introductionStory;
    }
}
