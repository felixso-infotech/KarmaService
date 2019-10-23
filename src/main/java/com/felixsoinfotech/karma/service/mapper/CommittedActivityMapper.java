package com.felixsoinfotech.karma.service.mapper;

import com.felixsoinfotech.karma.domain.*;
import com.felixsoinfotech.karma.service.dto.CommittedActivityDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity CommittedActivity and its DTO CommittedActivityDTO.
 */
@Mapper(componentModel = "spring", uses = {ActivityMapper.class, RegisteredUserMapper.class})
public interface CommittedActivityMapper extends EntityMapper<CommittedActivityDTO, CommittedActivity> {

    @Mapping(source = "activity.id", target = "activityId")
    @Mapping(source = "registeredUser.id", target = "registeredUserId")
    @Mapping(source = "reference.id", target = "referenceId")
    CommittedActivityDTO toDto(CommittedActivity committedActivity);

    @Mapping(source = "activityId", target = "activity")
    @Mapping(target = "activityProofs", ignore = true)
    @Mapping(target = "committedActivities", ignore = true)
    @Mapping(source = "registeredUserId", target = "registeredUser")
    @Mapping(source = "referenceId", target = "reference")
    CommittedActivity toEntity(CommittedActivityDTO committedActivityDTO);

    default CommittedActivity fromId(Long id) {
        if (id == null) {
            return null;
        }
        CommittedActivity committedActivity = new CommittedActivity();
        committedActivity.setId(id);
        return committedActivity;
    }
}
