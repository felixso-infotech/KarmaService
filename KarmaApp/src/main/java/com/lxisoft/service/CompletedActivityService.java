package com.lxisoft.service;

import com.lxisoft.service.dto.CompletedActivityDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing CompletedActivity.
 */
public interface CompletedActivityService {

    /**
     * Save a completedActivity.
     *
     * @param completedActivityDTO the entity to save
     * @return the persisted entity
     */
    CompletedActivityDTO save(CompletedActivityDTO completedActivityDTO);

    /**
     * Get all the completedActivities.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<CompletedActivityDTO> findAll(Pageable pageable);


    /**
     * Get the "id" completedActivity.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<CompletedActivityDTO> findOne(Long id);

    /**
     * Delete the "id" completedActivity.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
