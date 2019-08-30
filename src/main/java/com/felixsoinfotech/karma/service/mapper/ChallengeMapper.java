package com.felixsoinfotech.karma.service.mapper;

import com.felixsoinfotech.karma.domain.*;
import com.felixsoinfotech.karma.service.dto.ChallengeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Challenge and its DTO ChallengeDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ChallengeMapper extends EntityMapper<ChallengeDTO, Challenge> {


    @Mapping(target = "completedChallenges", ignore = true)
    @Mapping(target = "activities", ignore = true)
    Challenge toEntity(ChallengeDTO challengeDTO);

    default Challenge fromId(Long id) {
        if (id == null) {
            return null;
        }
        Challenge challenge = new Challenge();
        challenge.setId(id);
        return challenge;
    }
}
