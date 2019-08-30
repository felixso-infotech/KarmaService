package com.felixsoinfotech.karma.service.mapper;

import com.felixsoinfotech.karma.domain.*;
import com.felixsoinfotech.karma.service.dto.CompletedChallengeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity CompletedChallenge and its DTO CompletedChallengeDTO.
 */
@Mapper(componentModel = "spring", uses = {ChallengeMapper.class, UserMapper.class})
public interface CompletedChallengeMapper extends EntityMapper<CompletedChallengeDTO, CompletedChallenge> {

    @Mapping(source = "challenge.id", target = "challengeId")
    @Mapping(source = "user.id", target = "userId")
    CompletedChallengeDTO toDto(CompletedChallenge completedChallenge);

    @Mapping(source = "challengeId", target = "challenge")
    @Mapping(target = "proofs", ignore = true)
    @Mapping(source = "userId", target = "user")
    CompletedChallenge toEntity(CompletedChallengeDTO completedChallengeDTO);

    default CompletedChallenge fromId(Long id) {
        if (id == null) {
            return null;
        }
        CompletedChallenge completedChallenge = new CompletedChallenge();
        completedChallenge.setId(id);
        return completedChallenge;
    }
}
