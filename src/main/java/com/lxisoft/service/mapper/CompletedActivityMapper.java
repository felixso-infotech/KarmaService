package com.lxisoft.service.mapper;

import com.lxisoft.domain.*;
import com.lxisoft.service.dto.CompletedActivityDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity CompletedActivity and its DTO CompletedActivityDTO.
 */
@Mapper(componentModel = "spring", uses = {RegisteredUserMapper.class, ActivityMapper.class})
public interface CompletedActivityMapper extends EntityMapper<CompletedActivityDTO, CompletedActivity> {

    @Mapping(source = "registeredUser.id", target = "registeredUserId")
    @Mapping(source = "activityid.id", target = "activityId")
    CompletedActivityDTO toDto(CompletedActivity completedActivity);

    @Mapping(source = "registeredUserId", target = "registeredUser")
    @Mapping(target = "proofs", ignore = true)
    @Mapping(source = "activityId", target = "activityid")
    CompletedActivity toEntity(CompletedActivityDTO completedActivityDTO);

    default CompletedActivity fromId(Long id) {
        if (id == null) {
            return null;
        }
        CompletedActivity completedActivity = new CompletedActivity();
        completedActivity.setId(id);
        return completedActivity;
    }
}
