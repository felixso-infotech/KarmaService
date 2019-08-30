package com.felixsoinfotech.karma.service;

import com.felixsoinfotech.karma.service.dto.CompletedChallengeDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing CompletedChallenge.
 */
public interface CompletedChallengeService {

    /**
     * Save a completedChallenge.
     *
     * @param completedChallengeDTO the entity to save
     * @return the persisted entity
     */
    CompletedChallengeDTO save(CompletedChallengeDTO completedChallengeDTO);

    /**
     * Get all the completedChallenges.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<CompletedChallengeDTO> findAll(Pageable pageable);


    /**
     * Get the "id" completedChallenge.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<CompletedChallengeDTO> findOne(Long id);

    /**
     * Delete the "id" completedChallenge.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
