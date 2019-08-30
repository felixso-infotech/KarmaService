package com.felixsoinfotech.karma.service;

import com.felixsoinfotech.karma.service.dto.CommittedActivityDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing CommittedActivity.
 */
public interface CommittedActivityService {

    /**
     * Save a committedActivity.
     *
     * @param committedActivityDTO the entity to save
     * @return the persisted entity
     */
    CommittedActivityDTO save(CommittedActivityDTO committedActivityDTO);

    /**
     * Get all the committedActivities.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<CommittedActivityDTO> findAll(Pageable pageable);


    /**
     * Get the "id" committedActivity.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<CommittedActivityDTO> findOne(Long id);

    /**
     * Delete the "id" committedActivity.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
